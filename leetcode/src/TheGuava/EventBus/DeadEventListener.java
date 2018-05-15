package TheGuava.EventBus;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * Created by tangjialiang on 2018/1/30.
 */
public class DeadEventListener {

    boolean isDelivered=true;

    @Subscribe
    public void listen(DeadEvent event){
        isDelivered=false;
        System.out.println(event.getSource().getClass()+"  "+event.getEvent()); //source通常是EventBus
    }

    public boolean isDelivered() {
        return isDelivered;
    }
}
