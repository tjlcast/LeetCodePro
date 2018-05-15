package zz_to_offer;

/**
 * Created by tangjialiang on 2017/8/21.
 */
public class Page_44 {
    /**
        *
        * 替换字符串的空格为制定字符串
        * */

    public static void main(String[] args) {
        String str = "abc ddf df" ;
        String word = "apple" ;

        String s = new MySolution().replaceStr(str, word);
        System.out.println("ans is: " + s) ;
    }

    static class MySolution{
        String replaceStr(String s, String str) {
            String ans = null ;

            String s1 = s.replaceAll(" ", str) ;
            return ans = s1 ;
        }
    }
}
