package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/10.
 */
public class _65_Valid_Number {
    /**
     * Validate if a given string is numeric.

     Some examples:
     "0" => true
     " 0.1 " => true
     "abc" => false
     "1 a" => false
     "2e10" => true
     Note: It is intended for the problem statement to be ambiguous.
     You should gather all requirements up front before implementing one.

     Update (2015-02-10):
     The signature of the C++ function had been updated.
     If you still see your function signature accepts a const char * argument,
     please click the reload button  to reset your code definition.
     */

    public static void main(String[] args) {
        String s = "2e10" ;
        _65_Valid_Number valid_number = new _65_Valid_Number();
        boolean work = valid_number.work(s);

        System.out.println("work is: " + work) ;
    }

    public boolean work(String s) {
        Solution solution = new Solution();
        boolean number = solution.isNumber(s);

        return number ;
    }

    class Solution {
        public boolean isNumber(String s) {
            return s.matches("(\\s*)[+-]?((\\.[0-9]+)|([0-9]+(\\.[0-9]*)?))(e[+-]?[0-9]+)?(\\s*)");
        }
    }
}
