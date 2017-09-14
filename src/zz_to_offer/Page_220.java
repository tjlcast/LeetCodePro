package zz_to_offer;

/**
 * Created by tangjialiang on 2017/8/31.
 */
public class Page_220 {
    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。
     * 比如输入字符串"abcdefg"和数字2，该函数将返回左旋转2位得到的结果"cdefgab".
     */

    public static void main(String[] args) {
        String str = "abcdefg" ;
        int n = 2 ;
        Page_220 page_220 = new Page_220();
        String work = page_220.work(str, n);
        System.out.println("work is: " + work) ;
    }

    public String work(String str, int n) {
        MySolution mySolution = new MySolution();
        String s = mySolution.leftRotateString(str, n);
        return s ;
    }

    class MySolution {
        String leftRotateString(String str, int n) {

            StringBuilder sb = new StringBuilder(str) ;
            reverse(sb, 0, n-1);
            reverse(sb, n, sb.length()-1);
            reverse(sb, 0, sb.length()-1);

            return sb.toString() ;
        }

        private void reverse(StringBuilder sb, int s, int e) {
            if (sb==null || s>e) return ;

            String substring = sb.substring(s, e + 1);
            String s1 = new StringBuilder(substring).reverse().toString();

            for(int i=0; i<s1.length(); i++) {
                sb.setCharAt(s+i, s1.charAt(i));
            }
        }
    }
}
