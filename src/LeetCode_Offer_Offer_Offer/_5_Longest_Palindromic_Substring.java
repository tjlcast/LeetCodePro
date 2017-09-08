package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/8/31.
 *
 */
public class _5_Longest_Palindromic_Substring {
    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

     Example:

     Input: "babad"

     Output: "bab"

     Note: "aba" is also a valid answer.
     Example:

     Input: "cbbd"

     Output: "bb"
     */

    public static void main(String[] args) {
        String str = "accvb" ;

        _5_Longest_Palindromic_Substring longest_palindromic_substring = new _5_Longest_Palindromic_Substring() ;
        String work = longest_palindromic_substring.work(str);

        System.out.println("work is: " + work) ;
    }

    public String work(String s) {
        Solution1 solution = new Solution1();
        String s1 = solution.longestPalindrome(s);
        return s1 ;
    }



    class Solution {
        /**
         * 动态规划： 时间复杂度为n*log(n)具象化。n*n的矩阵对角线的一半遍历。
         *
         * dp(i, j) = dp(i+1, j-1),
         * 注意： 边界情况，dp(i, i) = 1: 即一个元素的情况
         *                dp(i, i+1) = 1: 即两个元素相邻且相同的情况
         *
         */
        private int[][] dp = null ;
        private int maxLen = 1 ;
        private int start = 0 ;
        private int end = 0 ;

        public String longestPalindrome(String s) {
            String ans = null  ;
            if (s==null || s.length()==0) return ans ;
            initial(s);

            for(int k=2; k<s.length(); k++) {
                for(int j=k; j<s.length(); j++) {
                    int i = j - k ;
                    if (dp[i+1][j-1]==1 && s.charAt(i)==s.charAt(j)) {
                        dp[i][j] = 1 ;
                        maxLen = Math.max(j-i+1, maxLen) ;
                        start = i ;
                        end = j ;
                    }
                }
            }

            ans = s.substring(start, end+1) ;
            return ans ;
        }

        private void initial(String s) {
            int len = s.length() ;
            if (len <= 0) throw new IllegalArgumentException() ;

            dp = new int[len][len] ;

            for(int i=0; i<len; i++) {
                dp[i][i] = 1 ;
                if (i<len-1 && s.charAt(i)==s.charAt(i+1)) {
                    dp[i][i+1]=1 ;
                    maxLen = 2 ;
                    start = i ;
                    end = i+1 ;
                }
            }
        }

    }

    class Solution1 {
        /**
         * 使用子解的递归树，从root往下递归处理。
         * 叶子节点的确定为 判断长度为 1和2时
         *
         * 递归遍历的三种方式:(i,j)=(i+1,j) (i,j)=(i,j-1) (i,j)=(i+1,j-1)
         */

        private int maxLen = 0 ;
        private int maxL = 0 ;
        private int maxR = 0 ;
        private int isP[][] = null ;

        public String longestPalindrome(String s) {
            isP = new int[s.length()][s.length()] ;
            recursion(0, s.length()-1, s) ;
            return s.substring(maxL, maxR+1) ;
        }

        private boolean recursion(int l, int r, String s) {
            if (isP[l][r] != 0) return (isP[l][r]==1) ? (true) : (false);

            if (l == r) {
                isP[l][r] = 1 ;
                if (maxLen < 1) {
                    maxLen = 1 ;
                    maxL = l ;
                    maxR = r ;
                }
                return true ;
            }
            if (r-l==1 && s.charAt(l)==s.charAt(r)) {
                isP[l][r] = 1 ;
                if (maxLen < 2) {
                    maxLen = 2 ;
                    maxL = l ;
                    maxR = r ;
                }
                return true ;
            }

            if (s.charAt(l)==s.charAt(r) && recursion(l+1, r-1, s)) {
                isP[l][r] = 1 ;
                if (maxLen < r-l+1) {
                    maxLen = r-l+1 ;
                    maxL = l ;
                    maxR = r ;
                }
                return true ;
            } else {
                isP[l][r] = 2 ;
                if (l+1 <= r) recursion(l+1, r, s) ;
                if (l <= r-1) recursion(l, r-1, s) ;
                return false ;
            }
        }

    }

}
