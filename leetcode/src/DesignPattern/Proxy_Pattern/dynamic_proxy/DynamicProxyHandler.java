package DesignPattern.Proxy_Pattern.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by tangjialiang on 2018/3/29.
 */
public class DynamicProxyHandler implements InvocationHandler{
    private Object realObject ;

    public DynamicProxyHandler(Object realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 这里编写代理的扩展方法
        System.out.println("proxy do") ;

        return method.invoke(realObject, args) ;
    }

    /**
     * 用于测试动态代理
     *
     * 真实对象：RealObject，代理接口：Action，代理实例：Proxy
     *
     1、生成代理类Proxy的Class对象。

     2、如果Class作用域为私有，通过 setAccessible 支持访问

     3、获取Proxy Class构造函数，创建Proxy代理实例。
     *
     * @param args
     */
    public static void main(String[] args) {
        RealObject realObject = new RealObject() ;

        Action proxy = (Action)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Action.class}, new DynamicProxyHandler(realObject));

        proxy.doSomething() ;
    }
}
