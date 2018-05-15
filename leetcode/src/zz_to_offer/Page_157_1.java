package zz_to_offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/8/28.
 */
public class Page_157_1 {
    /**
     * 输入一个含有8个数字的数组，判断有没有可能把这8个数字分别放到正方体的8个顶点上，使得正方体上三组相对的面上的4个顶点的和都相等。
     * @param args
     */
    public static void main(String[] args) {
        String str = "12345678" ;
        List<String> work = new Page_157_1().work(str);
        for(String nodes: work) {
            System.out.println("work: " + nodes) ;
        }
    }

    public List<String> work(String str) {
        return new MySolution().judgeNodesEqual(str) ;
    }

    class MySolution {
        List<String> strList = new LinkedList<String>() ;

        public List<String> judgeNodesEqual(String str) {
            List<String> ans = new LinkedList<>() ;
            List<String> permutation = permutation(str);
            for(String nodes: permutation) {
                System.out.println("nodes: " + nodes) ;
                if (inCondition(nodes)) {
                    ans.add(nodes) ;
                }
            }

            return ans ;
        }

        private boolean inCondition(String nodes) {
            if ((nodes.charAt(0)-'0') +
                    (nodes.charAt(1)-'0') +
                    (nodes.charAt(2)-'0') +
                    (nodes.charAt(3)-'0') !=
                    (nodes.charAt(4)-'0') +
                            (nodes.charAt(5)-'0') +
                            (nodes.charAt(6)-'0') +
                            (nodes.charAt(7)-'0')) { return false ;}
            if ((nodes.charAt(0)-'0') +
                    (nodes.charAt(2)-'0') +
                    (nodes.charAt(4)-'0') +
                    (nodes.charAt(6)-'0') !=
                    (nodes.charAt(1)-'0') +
                            (nodes.charAt(3)-'0') +
                            (nodes.charAt(5)-'0') +
                            (nodes.charAt(7)-'0')) { return false ;}
            if ((nodes.charAt(0)-'0') +
                    (nodes.charAt(1)-'0') +
                    (nodes.charAt(4)-'0') +
                    (nodes.charAt(5)-'0') !=
                    (nodes.charAt(2)-'0') +
                            (nodes.charAt(3)-'0') +
                            (nodes.charAt(6)-'0') +
                            (nodes.charAt(7)-'0')) { return false ;}
            return true ;
        }

        private List<String> permutation(String str) {
            if (str == null) return strList ;
            generateAllString(new StringBuilder(str), 0) ;
            return strList ;
        }

        private void generateAllString(StringBuilder sb, int pos) {
            if (pos == sb.length()-1) {
                strList.add(sb.toString()) ;
            }

            for(int i=pos; i<sb.length(); i++) {
                // swap
                char c = sb.charAt(pos);
                sb.setCharAt(pos, sb.charAt(i));
                sb.setCharAt(i, c);

                // into recursion: i+1
                generateAllString(new StringBuilder(sb), pos+1);
            }
        }
    }
}
