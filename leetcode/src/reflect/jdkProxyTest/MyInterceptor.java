package reflect.jdkProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by tangjialiang on 2018/5/7.
 */
public class MyInterceptor implements InvocationHandler {

    private Object target ;

    public MyInterceptor(Object target) {
        this.target = target ;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke before");

        Object result = method.invoke(this.target, args);

        System.out.println("invoke after") ;

        return result;
    }
}
