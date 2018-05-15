package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/1.
 */
public class _9_Palindrome_Number {
    /**
     * Determine whether an integer is a palindrome. Do this without extra space.

     Some hints:
     Could negative integers be palindromes? (ie, -1)

     If you are thinking of converting the integer to string, note the restriction of using extra space.

     You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

     There is a more generic way of solving this problem.
     */

    public static void main(String[] args){
        int x = -2147447412 ;
        _9_Palindrome_Number palindrome_number = new _9_Palindrome_Number();
        boolean work = palindrome_number.work(x);
        System.out.println("work is: " + work) ;
    }

    public boolean work(int x) {
        Solution solution = new Solution();
        boolean palindrome = solution.isPalindrome(x);
        return palindrome ;
    }

    class Solution {
        /**
         * 设置两个指针分别指向当前判断的高位和地位。边界条件为高位指针与低位指针相同时，或者高针小于低针时，相等。
         * 注意：在本题中，负数全不是回文数。
         */
        public boolean isPalindrome(int x) {
            if (x < 0) return false ;

            int bits = 0 ;
            int tempX = x ;
            while(tempX != 0) {
                tempX = tempX / 10 ;
                bits ++ ;
            }

            return isPalindrome(x, bits, 1) ;
        }

        private boolean isPalindrome(int x, int high, int low) {
            if (high <= low) return true ;

            int highVal = (x / (int)Math.pow(10, high-1)) % 10 ;
            int lowVal = (x / (int)Math.pow(10, low-1)) % 10 ;

            if (highVal == lowVal) {
                return isPalindrome(x, high-1, low+1) ;
            }

            return false ;
        }


    }
}
