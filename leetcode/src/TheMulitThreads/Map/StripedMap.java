package TheMulitThreads.Map;

/**
 * Created by tangjialiang on 2018/1/25.
 */
public class StripedMap {
    // 同步策略: buckets[n] 由 locks[n%N_LOCKS]来保护

    private static final int N_LOCKS = 16 ;
    private final Node[] buckets ;
    private final Object[] locks ;

    private static class Node<K, V>{
        public K key ;
        public V value ;
        public Node next ;
        Node next() {
            return null ;
        }
    } ;

    public StripedMap(int numBuckets) {
        buckets = new Node[numBuckets] ;
        locks = new Object[numBuckets] ;
        for(int i=0; i<N_LOCKS; i++) {
            locks[i] = new Object() ;
        }
    }

    private final int hash(Object key) {
        return Math.abs(key.hashCode() % buckets.length) ;
    }

    public Object get(Object key) {
        int hash = hash(key) ;
        synchronized (locks[hash % N_LOCKS]) {
            for(Node m = buckets[hash]; m!=null; m=m.next()) {
                if (m.key.equals(key))
                    return m.value ;
            }
        }
        return null ;
    }

    public void clear() {
        // 得到所有的的同步锁，不是同时
        for(int i=0; i<buckets.length; i++) {
            synchronized (locks[i % N_LOCKS]) {
                buckets[i] = null ;
            }
        }
    }
}
