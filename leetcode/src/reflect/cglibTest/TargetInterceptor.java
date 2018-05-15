package reflect.cglibTest;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by tangjialiang on 2018/5/6.
 *
 * 目标对象拦截器，实现MethodInterceptor
 */
public class TargetInterceptor implements MethodInterceptor{
    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before: ") ;
        Object result = methodProxy.invokeSuper(obj, objects);
        System.out.println("after: " + result) ;
        return result ;
    }
}
