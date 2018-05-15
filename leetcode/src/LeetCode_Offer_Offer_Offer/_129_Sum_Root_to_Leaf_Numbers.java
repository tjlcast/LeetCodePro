package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

/**
 * Created by tangjialiang on 2017/11/28.
 */
public class _129_Sum_Root_to_Leaf_Numbers {

    static class Solution {
        private int total = 0 ;

        public int sumNumbers(TreeNode root) {
            dfs(root, 0) ;

            return total ;
        }

        private void dfs(TreeNode root, int count) {
            if (root == null) return ;

            count = count * 10 + root.val ;
            if (root.left==null && root.right==null) {
                total += count ;
            }

            dfs(root.left, count) ;
            dfs(root.right, count) ;

            return ;
        }
    }
}
