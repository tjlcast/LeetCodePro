package reflect.jdkProxyTest;

/**
 * Created by tangjialiang on 2018/5/7.
 */
public class TargetObject implements TargetInterface {
    @Override
    public void business() {
        System.out.println("business") ;
    }
}
