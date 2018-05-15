package Timer;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by tangjialiang on 2018/4/29.
 *
 * A timing-wheel optimized for approximated I/O timeout scheduling.
 */
public class TimingWheel<E> {

    private final long tickDuration ;
    private final int ticksPerWheel ;
    private volatile int currentTickIndex = 0 ;

    private final CopyOnWriteArrayList<ExpirationListener<E>> expirationListeners
            = new CopyOnWriteArrayList<>() ;
    private final ArrayList<Slot<E>> wheel ;
    private final Map<E, Slot<E>> indicator = new ConcurrentHashMap<E, Slot<E>>() ;

    private final AtomicBoolean shutDown = new AtomicBoolean(false) ;
    private final ReadWriteLock lock = new ReentrantReadWriteLock() ;
    private Thread workerTread ;


    /**
     * construction of the class
     * @param tickDuration <int> tick duration with specified time unit.
     * @param ticksPerWheel <int> the number of tick in a round.
     * @param timeUnit <TimeUnit> the class of time
     */
    public TimingWheel(int tickDuration, int ticksPerWheel, TimeUnit timeUnit) {
        if (timeUnit == null) {
            throw new NullPointerException("unit") ;
        }
        if (tickDuration <= 0) {
            throw new IllegalArgumentException("tickDuration must be greater than 0: " + tickDuration) ;
        }
        if (ticksPerWheel <= 0) {
            throw new IllegalArgumentException("tickPerWheel must be greater than 0: " + ticksPerWheel) ;
        }

        this.wheel = new ArrayList<Slot<E>>() ;
        this.tickDuration = TimeUnit.MILLISECONDS.convert(tickDuration, timeUnit) ;
        this.ticksPerWheel = ticksPerWheel + 1 ;

        for (int i = 0; i < this.ticksPerWheel; i++) {
            wheel.add(new Slot<E>(i)) ;
        }
        wheel.trimToSize(); // 把该数组的实际长度变化到size大小.

        workerTread = new Thread(new TickWorker(), "Timing-Worker") ;
    }

    /**
     * start of the timer.
     */
    public void start() {
        if (shutDown.get()) {
            throw new IllegalStateException("Cannot be started once stopped") ;
        }

        if (!workerTread.isAlive()) {
            workerTread.start();
        }
    }

    /**
     * stop of the timer.
     * @return
     */
    public boolean stop() {
        if (!shutDown.compareAndSet(false, true)) {
            return false ;
        }

        boolean interrupted = false ;
        while (workerTread.isAlive()) {
            workerTread.interrupt();
            try {
                workerTread.join(100);
            } catch (InterruptedException e) {
                interrupted = true ;
            }
        }

        if (interrupted) {
            Thread.currentThread().interrupt();
        }

        return true ;
    }

    /**
     * add a expiration listener.
     * @param listener
     */
    public void addExpirationListener(ExpirationListener<E> listener) {
        expirationListeners.add(listener) ;
    }

    /**
     * remove a expiration listener.
     * @param listener
     */
    public void removeExpirationListener(ExpirationListener<E> listener) {
        expirationListeners.remove(listener) ;
    }

    /**
     * add a task to wheel.
     * @param e
     * @return
     */
    public long add(E e) {
        synchronized (e) {
            checkAdd(e);

            int previousTickIndex = getPreviousTickIndex() ;
            Slot<E> slot = wheel.get(previousTickIndex) ;
            slot.add(e) ;
            indicator.put(e, slot) ;

            return (ticksPerWheel - 1) * tickDuration ;
        }
    }

    private void checkAdd(E e) {
        Slot<E> slot = indicator.get(e) ;

        if (slot != null) {
            slot.remove(e) ;
        }
    }

    private int getPreviousTickIndex() {
        lock.readLock().lock();
        try {
            int cti = currentTickIndex ;
            if (cti == 0) {
                return ticksPerWheel - 1 ;
            }

            return cti - 1 ;
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * remove a task(e) from the timer.
     * @param e
     * @return
     */
    public boolean remove(E e) {
        synchronized (e) {
            Slot<E> slot = indicator.get(e) ;
            if (slot == null) {
                return false ;
            }

            indicator.remove(e) ;
            return slot.remove(e) != null ;
        }
    }

    private void notifyExpired(int idx) {
        Slot<E> slot = wheel.get(idx) ;
        Set<E> elements = slot.elements() ;

        for (E e :
                elements) {
            slot.remove(e) ;
            synchronized (e) {
                Slot<E> latestSlot = indicator.get(e);
                if (latestSlot.equals(slot)) {
                    latestSlot.remove(e) ;
                }
            }

            for (ExpirationListener<E> listener : expirationListeners) {
                listener.expired(e);
            }
        }
    }

    /**
     * the private thread of the wheel timer.
     */
    private class TickWorker implements Runnable {
        private long startTime ;
        private long tick ;

        @Override
        public void run() {
            startTime = System.currentTimeMillis() ;
            tick = 1 ;

            for (int i = 0; !shutDown.get(); i++) {
                if (i == wheel.size()) i = 0 ;

                lock.writeLock().lock();
                try {
                    currentTickIndex = i;
                } finally {
                    lock.writeLock().unlock();
                }
                notifyExpired(currentTickIndex);
                waitForNextTick();
            }
        }

        private void waitForNextTick() {
            for (;;) {
                long currentTime = System.currentTimeMillis() ;
                long sleepTime = tickDuration * tick - (currentTime - startTime) ;

                if (sleepTime < 0) {
                    break ;
                }

                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    return ;
                }
            }

            tick++ ;
        }
    }
}
