package reflect.jdkProxyTest;

import java.lang.reflect.Proxy;

/**
 * Created by tangjialiang on 2018/5/7.
 */
public class MainTest {

    public static void main(String[] args) {
        // 目标对象
        TargetObject targetObject = new TargetObject();
        // 拦截器
        MyInterceptor myInterceptor = new MyInterceptor(targetObject);

        TargetInterface targetProxy = (TargetInterface)Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), myInterceptor);
        targetProxy.business();

    }
}
