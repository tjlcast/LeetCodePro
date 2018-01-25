package DesignPattern.Decorator_Pattern;

/**
 * Created by tangjialiang on 2018/1/25.
 */
public abstract class Beverage {
    String description = "Unknown Beverage" ;

    public String getDescription() {
        return description ;
    }

    public abstract double cost() ;
}
