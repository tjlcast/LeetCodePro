package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/1.
 */
public class _8_String_to_Integer_atoi {
    /**
     * Implement atoi to convert a string to an integer.

     Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

     Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

     Update (2015-02-10):
     The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

     spoilers alert... click to show requirements for atoi.
     */

    public static void main(String[] args) {
        String str = "123" ;
        _8_String_to_Integer_atoi string_to_integer_atoi = new _8_String_to_Integer_atoi();
        int work = string_to_integer_atoi.work(str);
        System.out.println("work is " + work) ;
    }

    public int work(String str) {
        Solution solution = new Solution();
        int i = solution.myAtoi(str);
        return i ;
    }

    class Solution {
        public int myAtoi(String str) {
            if (str == null || str.length() == 0)
                return 0;//
            str = str.trim();
            char firstChar = str.charAt(0);
            int sign = 1, start = 0, len = str.length();
            long sum = 0;
            if (firstChar == '+') {
                sign = 1;
                start++;
            } else if (firstChar == '-') {
                sign = -1;
                start++;
            }
            for (int i = start; i < len; i++) {
                if (!Character.isDigit(str.charAt(i)))
                    return (int) sum * sign;
                sum = sum * 10 + str.charAt(i) - '0';
                if (sign == 1 && sum > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }

            return (int) sum * sign;
        }
    }
}
