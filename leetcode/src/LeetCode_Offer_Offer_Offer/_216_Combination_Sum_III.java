package LeetCode_Offer_Offer_Offer;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/1/22.
 */
public class _216_Combination_Sum_III {

    public static void main(String[] args) {
        int k = 3 ;
        int n = 15 ;

        Solution sol = new Solution() ;
        List<List<Integer>> ans = sol.combinationSum3(k, n) ;

        System.out.println("Thw work is; " ) ;
        for(List<Integer> l : ans) {
            for(Integer i : l) {
                System.out.print(i + " ") ;
            }
            System.out.println() ;
        }
    }

    static class Solution {

        List<List<Integer>> ans = new LinkedList<List<Integer>>() ;
        final int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9} ;
        int k ;
        int n ;

        public List<List<Integer>> combinationSum3(int k, int n) {
            LinkedList<Integer> arr = new LinkedList<>() ;
            this.k = k ;
            this.n = n ;
            backTrace(arr, 1, 0, 0);
            return ans ;
        }

        public void backTrace(LinkedList<Integer> arr, int pos, int curK, int curN) {
            if (curK==k && curN==n) {
                LinkedList<Integer> tmp = (LinkedList<Integer>)arr.clone() ;
                ans.add(tmp) ;
                return ;
            }

            if (pos > 9) return ;
            if (curK>k || curN>n) return ;

            // not
            backTrace(arr, pos+1, curK, curN) ;

            // add
            arr.addLast(pos);
            backTrace(arr, pos+1, curK+1, curN+pos);
            arr.removeLast() ;
        }
    }
}
