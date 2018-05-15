package TheGuava.EventBus;

import com.google.common.eventbus.Subscribe;

/**
 * Created by tangjialiang on 2018/1/30.
 */
public class MultiEventListener {

    private static final String clzName = MultiEventListener.class.getName() ;

    @Subscribe
    public void listen(OrderEvent event){
        System.out.println(clzName + ": " + Thread.currentThread().getName()) ;
        System.out.println(clzName + " receive msg: "+event.getMessage());
    }

    @Subscribe
    public void listen(String message){
        System.out.println(clzName + " receive msg: "+message);
    }
}