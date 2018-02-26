package TheMulitThreads.BoundedBuffer;

/**
 * Created by tangjialiang on 2018/2/4.
 *
 * 有界队列： 快速失败
 */
public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V> {
    public GrumpyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public synchronized void put(V v) throws Exception {
        if (isFull()) {
            throw new Exception("buffer is full!") ;
        }
        doPut(v);
    }

    public synchronized V take() throws Exception {
        if (isEmpty()) {
            throw new Exception("buffer is empty!") ;
        }
        return doTake() ;
    }
}
