package TheMulitThreads.BoundedBuffer;

/**
 * Created by tangjialiang on 2018/2/4.
 *
 * 有界队列： 通过轮训与休眠
 */
public class SleepyBoundedBuffer<V> extends BaseBoundedBuffer<V> {
    private final int SLEEP_GRANULARITY = 1500 ;

    public SleepyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public void put(V v) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isFull()) {
                    doPut(v);
                    return ;
                }
            }
            Thread.sleep(SLEEP_GRANULARITY);
        }
    }

    public V take() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isEmpty()) {
                    return doTake() ;
                }
            }
            Thread.sleep(SLEEP_GRANULARITY);
        }
    }
}
