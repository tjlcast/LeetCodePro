package TheGuava.Base;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangjialiang on 2018/1/30.
 */
public class JoinerDemo {

    /**
     *  on:制定拼接符号，如：test1-test2-test3 中的 “-“ 符号
        skipNulls()：忽略NULL,返回一个新的Joiner实例
        useForNull(“Hello”)：NULL的地方都用字符串”Hello”来代替
     * @param args
     */
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder() ;

        // case no1.
        Joiner.on(",").skipNulls().appendTo(sb, "hello", "guava") ;
        System.out.println(sb) ;

        // case no2.
        System.out.println(Joiner.on(",").useForNull("one").join(1, null, 3)) ;

        // case no3.
        System.out.println(Joiner.on(",").skipNulls().join(Arrays.asList(1, 2, 3, 4, null, 6))) ;

        // case no4.
        Map<String, String> map = new HashMap<>() ;
        map.put("key1", "value1") ;
        map.put("key2","value2");
        map.put("key3","value3");
        System.out.println(Joiner.on(",").withKeyValueSeparator("=").join(map)) ;
    }
}
