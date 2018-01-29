package DesignPattern.Factory_Pattern;

/**
 * Created by tangjialiang on 2018/1/25.
 */
public abstract class PizzaStore {

    /**
     * orderPizza()调用createPizza()取得披萨对象。
     * 但究竟取得哪一种比萨？这不是orderPizza()方法能
     * 决定的，应该PizzaStore来决定.
     * @param type
     * @return
     */
    public Pizza orderPizza(String type) {
        Pizza pizza ;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza ;
    }

    /**
     * 实例化披萨的责任被移到一个
     * "方法"中，此方法就是一个"工厂"
     * @param type
     * @return
     */
    public abstract Pizza createPizza(String type) ;
}
