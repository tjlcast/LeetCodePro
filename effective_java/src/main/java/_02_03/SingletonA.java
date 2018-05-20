package _02_03;

import java.lang.reflect.Constructor;

/**
 * Created by tangjialiang on 2018/5/19.
 */
public class SingletonA {

    private static SingletonA instance = new SingletonA() ;

    private SingletonA() {

    }

    public static SingletonA getInstance() {
        return instance ;
    }

    /**
     * 以这种写法存在缺陷，可以使用反射的方式来实例化多个不同的实例
     * 如下所示
     **/
    public static void main(String[] args) {
        try {
            SingletonA s1 = SingletonA.getInstance();
            Class<SingletonA> singletonAClass = SingletonA.class;

            Constructor<SingletonA> constructor = singletonAClass.getDeclaredConstructor(new Class[]{});
            SingletonA s2 = constructor.newInstance(new Object[]{});

            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

