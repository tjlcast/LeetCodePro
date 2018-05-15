package zz_to_to_offer.solution;

/**
 * Created by tangjialiang on 2018/3/26.
 */
public class Solution00 {
    public String replaceSpace(StringBuffer str) {
        char patten = ' ' ;
        String replaceStr = "%20" ;
        StringBuilder sb = new StringBuilder() ;

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i) ;
            if (c == patten) {
                sb.append(replaceStr) ;
            } else {
                sb.append(c) ;
            }
        }

        return sb.toString() ;
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("hello world") ;

        Solution00 solution00 = new Solution00();
        String s = solution00.replaceSpace(str);

        System.out.println(s) ;
    }
}