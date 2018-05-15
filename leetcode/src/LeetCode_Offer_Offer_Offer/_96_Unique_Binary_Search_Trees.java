package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/21.
 */
public class _96_Unique_Binary_Search_Trees {
    /**
     * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

     For example,
     Given n = 3, there are a total of 5 unique BST's.

     1         3     3      2      1
     \       /     /      / \      \
     3     2     1      1   3      2
     /     /       \                 \
     2     1         2                 3
     */

    public static void main(String[] args) {

    }

    public int work(int n) {
        Solution solution = new Solution();
        int i = solution.numTrees(n);

        return i ;
    }

    class Solution {
        private int[][] dp = null ;

        public int numTrees(int n) {
            dp = new int[n+1][n+1] ;

            return countTrees(1, n) ;
        }

        private int countTrees(int l, int r) {

            int total = 0 ;

            if (l > r) {
                return 0 ;
            }
            if (dp[l][r]!=0) return dp[l][r] ;
            if (l == r) {
                return 1 ;
            }

            for(int i=l; i<=r; i++) {
                int count = 0 ;
                int rCount = countTrees(l, i-1) ; if (rCount==0) rCount=1 ;
                int lCount = countTrees(i+1, r) ; if (lCount==0) lCount=1 ;

                count += (rCount * lCount) ;

                total += count ;
            }
            dp[l][r] = total ;

            return total ;
        }
    }
}
