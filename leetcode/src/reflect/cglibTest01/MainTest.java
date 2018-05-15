package reflect.cglibTest01;

/**
 * Created by tangjialiang on 2018/5/7.
 */
public class MainTest {

    public static void main(String[] args) {
        //目标对象
        TargetObject targetObject = new TargetObject();
        //拦截器
        MyInterceptor myInterceptor = new MyInterceptor(targetObject);
        //代理对象，调用cglib系统方法自动生成
        //注意：代理类是目标类的子类。
        TargetObject proxy = (TargetObject)myInterceptor.createProxy();
        proxy.business();
    }
}
