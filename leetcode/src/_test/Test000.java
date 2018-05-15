package _test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tangjialiang on 2018/1/31.
 */
public class Test000 {

    public static volatile int race = 0 ;

    public static void increase() {
        race++ ;
    }

    public static final int THREADS_COUNT = 20 ;

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> chm = new ConcurrentHashMap<>() ;

        for(int i=0; i<1000; i++) {
            chm.put(i, i) ;
        }

        Thread[] threads = new Thread[THREADS_COUNT] ;
        for(int i=0; i<threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("current num of threads is: " + Thread.activeCount()) ;
                    ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
                    for(int i=0; i<10000; i++) {
                        increase();
                    }
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "thread-"+i) ;
            threads[i].start();
        }

        while (Thread.activeCount() >= 2) {
            Thread.yield();
        }

        System.out.println(race) ;
    }
}
