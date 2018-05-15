package Thejvm.MulitThreads;

/**
 * Created by tangjialiang on 2018/1/23.
 */
public class DeadLock {
    /**
     * 用于对多线程死锁的测试,
     * 线程的状态变化： blocked
     * 某个线程占有对象a，
     * 某个线程占有对象b
     */

    static class SynAddRunalbe implements Runnable {
        int a, b ;

        public SynAddRunalbe(int a, int b) {
            this.a = a ;
            this.b = b ;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) { // Integer.valueof在[-128, 127]之间的数字会被缓存， 所以1和2对象是同一个。
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }

    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            // System.out.println("i: " + i) ;
            new Thread(new SynAddRunalbe(1, 2)).start();
            new Thread(new SynAddRunalbe(2, 1)).start();
        }
    }
}
