import java.lang.annotation.Annotation;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tangjialiang on 2018/5/22.
 */
@MyAnnotationC("bupt")
public class Main {

    static class Student {
        String name = "123" ;
        int age = 123 ;
    }

    public static void main(String[] args) throws Exception{

        //ConcurrentHashMap<Integer, WeakReference<Runnable>> tasks = new ConcurrentHashMap<Integer, WeakReference<Runnable>>();

        Student ss = new Student() ;

        WeakReference<Thread> threadWeakReference = new WeakReference(new Thread() {
            @Override
            public void run() {
                try{
                    while (true){
                        Thread.sleep(1000);
                        System.out.println(1);
                    }
                }catch (Exception e){

                }
            }
        });
        threadWeakReference.get();

        while (true){
            System.gc();
            Thread.sleep(1000);
            threadWeakReference.get();
            System.out.println( threadWeakReference.get());
        }
    }
}
