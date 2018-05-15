package zz_to_offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/8/27.
 */
public class Page_154_pro {
    /**
     * 求字符的所有组合。
     * 例如：输入三个字符a，b，c，则它们的组合有a，b，c，ab，ac，bc，abc。
     */
    public static void main(String[] args) {
        String str = "abc" ;
        List<String> work = new Page_154_pro().work(str);
        for(String s : work) {
            System.out.println(s) ;
        }
    }

    public List<String> work(String str) {
        MySolution mySolution = new MySolution(str);
        return mySolution.combination();
    }

    class MySolution {
        /**
         * 根据"数组选与不选"的方法
         */
        List<String> ansList = new LinkedList<>() ;
        String str = null ;
        int len = -1 ;

        public MySolution() {
        }

        public MySolution(String str) {
            this.str = str ;
            this.len = str.length() ;
        }

        public List<String> combination() {
            combination("", 0);
            return ansList ;
        }

        private void combination(String inputStr, int pos) {
            if (pos == len) {
                ansList.add(inputStr) ;
                return ;
            }

            String word = str.substring(pos, pos + 1);
            combination(inputStr, pos+1);
            combination(inputStr+word, pos+1);
        }
    }
}
