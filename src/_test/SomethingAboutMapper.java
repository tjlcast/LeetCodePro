package _test;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by tangjialiang on 2017/9/3.
 */
public class SomethingAboutMapper {
    /**
     * tips: 从IdentityHashMap中可以看出java的整型非对象还是遵循常量区的相关规则。
     *      IdentityHashMap在使用堆区变量作为key可以实现key重复的需求。
     */

    public static void main(String[] args) {
        TreeMap<Integer, Character> tm = new TreeMap<>() ;

        tm.put(1, 't') ;
        tm.put(1, 'j') ;
        tm.put(3, 'n') ;

        Map m = new IdentityHashMap();
        m.put(new String("1"),"java");
        m.put(new String("1"),"js");
        m.put(new String("2"), "php");
        System.out.println(m);


        Map<Integer, String> map = new IdentityHashMap<>() ;

//        map.put(new Integer(1), "haha") ;
//        map.put(new Integer(1), "asd") ;
//        map.put(new Integer(2), "qwe") ;

        map.put(1, "haha") ;
        map.put(2, "asd") ;
        map.put(1, "qwe") ;

        System.out.println(map) ;
    }
}
