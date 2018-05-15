package DesignPattern.Decorator_Pattern;

/**
 * Created by tangjialiang on 2018/1/25.
 *
 * 对扩张开发，对修改关闭
 */
public class StarbuzzCoffee {
    /**
     * 拿一个Espresso咖啡
     * 以Mocha对象来装饰它
     * 调用cost()方法，并依赖委托将调料的价格加上去
     *
     * 装饰模式对某个接口的实现进行再包装。
     *
     * @param args
     */
    public static void main(String[] args) {
        Beverage beverage = new Espresso() ;
        System.out.println(beverage.getDescription()
        + " $" + beverage.cost()) ;

        Beverage beverage1 = new Espresso() ;
        beverage1 = new Mocha(beverage1) ;
    }
}
