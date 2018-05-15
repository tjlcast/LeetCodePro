package _test;

import java.util.HashMap;

/**
 * Created by tangjialiang on 17/5/12.
 */
public class aboutPrintMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>() ;
        map.put("hello", 1) ;
        map.put("world", 2) ;

        System.out.println(map.toString()) ;
    }
}