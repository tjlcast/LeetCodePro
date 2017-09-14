package zz_to_offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/8/26.
 */
public class Page_154 {
    /**
     * 输入一个字符串，打印该字符串中字符的所有排列。
     * 例如输入字符串abc,则打印出由字符a,b,c所有能排序出来的所有字符串abc,acb,bac,bca,cab和cba
     */

    public static void main(String[] args) {
        String str = "abc" ;
        List<String> work = new Page_154().work(str);
        for(String s : work) {
            System.out.println(s) ;
        }
    }

    public List<String> work(String str) {
        return new MySolution().permutation(str) ;
    }

    class MySolution {
        /**
         * "拿第一个字符和它后面的字符逐个交换" === 让后面的字符都放在第一个字符一次，形成一个当前状态。
         */
        List<String> ans = new LinkedList<String>() ;

        public List<String> permutation(String str) {
            if (str == null) return ans ;
            generateAllString(new StringBuilder(str), 0) ;
            return ans ;
        }

        private void generateAllString(StringBuilder str, int pos) {
            if (pos == str.length()-1) {
                ans.add(str.toString()) ;
            }

            for(int i=pos; i<str.length(); i++) {
                // swap
                char c = str.charAt(pos);
                str.setCharAt(pos, str.charAt(i));
                str.setCharAt(i, c);

                // into recursion: i+1
                generateAllString(new StringBuilder(str), pos+1);
            }
        }
    }
}
