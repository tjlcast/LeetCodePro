package TheMulitThreads.BoundedBuffer;

/**
 * Created by tangjialiang on 2018/2/4.
 *
 * 有界队列：  条件队列
 */
public class InnerConditionedBoundedBuffer<V> extends  BaseBoundedBuffer<V> {

    public InnerConditionedBoundedBuffer(int capacity) {
        super(capacity);
    }

    public synchronized void put(V v) throws InterruptedException {
        while(isFull()) {
            wait();
        }
        doPut(v);
        notifyAll();
    }

    public synchronized V take() throws InterruptedException {
        while(isEmpty()) {
            wait() ;
        }
        V v = doTake() ;
        notifyAll();
        return v ;
    }
}
