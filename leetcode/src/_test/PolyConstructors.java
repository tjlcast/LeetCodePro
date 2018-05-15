package _test;

/**
 * Created by tangjialiang on 2017/8/30.
 *
 * 有关 class 的实例
 *
 * 在实例一个类时，会为类的字段以默认值的方式开辟空间。
 * 构造函数通过调用函数对字段进行初始化（此时遵循函数的覆写规则）
 *
 * java中，字段初始化有两种方法：
 *         1／ 在字段之后直接赋值。
 *         2／ 在构造方法中进行赋值。
 *
 *         1方法是否可以类比到scala中的主构造方法。所谓的"肯定会调用的初始化操作"。
 *         但java中1方法在是先于所有的构造方法。
 *         java中的构造器重载之间没有必须调用关系（不强制要求形成调用链）
 */
public class PolyConstructors {

    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}

class Glyph {
    void draw() {
        System.out.println("Glyph.draw()") ;
    }

    public Glyph() {
        System.out.println("Glyph() before draw()") ;
        draw() ;
        System.out.println("Glyph() after draw()") ;
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1 ;

    public RoundGlyph(int r) {
        System.out.println("the radius is " + radius) ;
        radius = r ;
        System.out.println("RoundGlyph.draw(), radius = " + radius) ;
    }

    public void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius) ;
    }
}
