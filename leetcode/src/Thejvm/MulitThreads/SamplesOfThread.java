package Thejvm.MulitThreads;

import java.io.* ;

/**
 * Created by tangjialiang on 2018/1/23.
 */
public class SamplesOfThread {

    /**
     * 线程死循环演示
     * 用于测试线程的状态变化: runing, waiting
     */
    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true)
                    ;
            }
        }, "testBusyThread") ;
        thread.start();
    }

    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread") ;
        thread.start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        br.readLine() ;
        createBusyThread();
        br.readLine() ;
        Object obj = new Object();
        createLockThread(obj);
    }
}
