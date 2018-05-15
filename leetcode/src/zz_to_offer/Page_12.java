package zz_to_offer;

/**
 * Created by tangjialiang on 2017/8/16.
 */
public class Page_12 {
    public static void main(String[] args) {
        String str = "123" ;
        int work = new Page_12().work(str);
        System.out.println(work) ;
    }

    public int work(String str) {
        return new ProblemPage12().converString2Integer(str) ;
    }

    class ProblemPage12 {
        /**
        * 把一个字符串转换为整型数
        * */
        int converString2Integer(String str) {
            int num = 0 ;
            boolean isNegitive = false ;
            int pos = 0 ;

            if (str.length() == 0) return num ;

            if (str.charAt(pos++) == '-') isNegitive = true ;

            while(pos < str.length()) {
                char c = str.charAt(pos) ;
                if (!('0' <= c && c <= '9')) return -1 ;
                num = num * 10 + (c - '0') ;
                pos = pos + 1 ;
            }

            return (isNegitive) ? num * (-1) : num ;
        }
    }
}
