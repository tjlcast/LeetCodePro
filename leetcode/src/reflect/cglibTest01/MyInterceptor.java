package reflect.cglibTest01;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by tangjialiang on 2018/5/7.
 */
public class MyInterceptor implements MethodInterceptor {
    private Object target ;

    public MyInterceptor(Object target) {
        this.target = target;
    }

    public Object createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this); //回调函数  拦截器
        //设置代理对象的父类,可以看到代理对象是目标对象的子类。所以这个接口类就可以省略了。
        enhancer.setSuperclass(this.target.getClass());
        return enhancer.create() ;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // Object为由CGLib动态生成的代理类实例，
        // Method为上文中实体类所调用的被代理的方法引用，
        // Object[]为参数值列表，
        // MethodProxy为生成的代理类对方法的代理引用。
        System.out.println("===== before ====") ;

        method.invoke(this.target, objects) ;

        System.out.println("===== after =====");
        return null ;
    }
}
