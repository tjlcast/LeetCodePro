package zz_to_offer;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2017/8/29.
 */
public class Page_186 {
    /**
     * 在字符串中找到第一个只出现一次的字符，如输入"abaccdeff"，则输出'b'
     */

    public static void main(String[] args) {
        String msg = "abaccdeff" ;
        Page_186 page_186 = new Page_186();
        char work = page_186.work(msg);
        System.out.println("work: " + work) ;
    }

    public char work(String msg) {
        MySolution mySolution = new MySolution();
        return mySolution.firstNotRepeatingChar(msg) ;
    }

    class MySolution {
        HashMap<Character, Integer> recorder = new HashMap<>() ; //<word, times>

        public char firstNotRepeatingChar(String msg) {
            int lastAppearWordPos = -1 ;

            for(int i=msg.length()-1; i>=0; i--) {
                char c = msg.charAt(i);
                Integer orDefault = recorder.getOrDefault(c, 0);
                if (orDefault == 0) {
                    lastAppearWordPos = i ;
                }
                recorder.put(c, orDefault + 1) ;
            }

            if (lastAppearWordPos == -1) throw new ArithmeticException() ;
            char c = msg.charAt(lastAppearWordPos);
            return c ;
        }
    }
}
