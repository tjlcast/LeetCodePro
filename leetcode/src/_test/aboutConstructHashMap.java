package _test;

import java.util.HashMap;

/**
 * Created by tangjialiang on 17/5/11.
 */
public class aboutConstructHashMap {
    public static void main(String[] args) {
        long start = System.currentTimeMillis() ;
        HashMap<String, Integer> counts = new HashMap<>() ;
        System.out.println(System.currentTimeMillis() - start);
        counts.put("hello", 1) ;
        counts.put("world", Integer.MAX_VALUE) ;
        counts.put("bupt", Integer.MAX_VALUE/2) ;
        start = System.currentTimeMillis() ;
        HashMap<String, Integer> copy = new HashMap<>(counts) ;
        System.out.println(System.currentTimeMillis() - start);
    }
}
