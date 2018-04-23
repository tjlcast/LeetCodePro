package DesignPattern.Proxy_Pattern.dynamic_proxy;

/**
 * Created by tangjialiang on 2018/3/29.
 */
public class RealObject implements Action {
    @Override
    public void doSomething() {
        System.out.println("do something") ;
    }
}
