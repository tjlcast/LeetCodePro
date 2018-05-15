package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/4.
 */
public class _38_Count_and_Say {
    /**
     * The count-and-say sequence is the sequence of integers with the first five terms as following:

     1.     1
     2.     11
     3.     21
     4.     1211
     5.     111221
     1 is read off as "one 1" or 11.
     11 is read off as "two 1s" or 21.
     21 is read off as "one 2, then one 1" or 1211.
     Given an integer n, generate the nth term of the count-and-say sequence.

     Note: Each term of the sequence of integers will be represented as a string.

     Example 1:

     Input: 1
     Output: "1"
     Example 2:

     Input: 4
     Output: "1211"
     */

    public static void main(String[] args) {
        int n = 6 ;
        _38_Count_and_Say count_and_say = new _38_Count_and_Say();
        String work = count_and_say.work(n);

        System.out.println("work is: " + work) ;
    }

    public String work(int n) {
        Solution solution = new Solution();
        String s = solution.countAndSay(n);
        return s ;
    }

    class Solution {
        public String countAndSay(int n) {
            String str = "1" ;
            for(int i=1; i<n; i++) {
                str = generate(str) ;
            }
            return str ;
        }

        private String generate(String s) {
            StringBuilder sb = new StringBuilder() ;

            int l = 0 ;
            int r = 1 ;
            do{
                while(r < s.length() && s.substring(l, l+1).equals(s.substring(r, r+1))) {
                    r++ ;
                }
                int num = r - l ;
                sb.append(num + "" + s.substring(l, l+1)) ;
                l = r ;
            } while(r < s.length()) ;

            return sb.toString() ;
        }
    }
}
