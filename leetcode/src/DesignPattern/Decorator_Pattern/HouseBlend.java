package DesignPattern.Decorator_Pattern;

/**
 * Created by tangjialiang on 2018/1/25.
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "HouseBlend" ;
    }

    @Override
    public double cost() {
        return 0.89 ;
    }
}
