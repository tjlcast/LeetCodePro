package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

/**
 * Created by tangjialiang on 2017/11/27.
 */
public class _124_Binary_Tree_Maximum_Path_Sum {
    /**
     * Given a binary tree, find the maximum path sum.

     For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

     For example:
     Given the below binary tree,

     1
     / \
     2   3
     Return 6.
     */

    class Solution {

        private int total = Integer.MIN_VALUE ;

        public int maxPathSum(TreeNode root) {
            dfs(root) ;
            return total ;
        }

        private int dfs(TreeNode root) {
            if (root == null) return 0 ;

            int leftTotal = dfs(root.left) ;
            int rightTotal = dfs(root.right) ;

            total = Math.max(total, root.val) ;
            total = Math.max(total, root.val+leftTotal) ;
            total = Math.max(total, root.val+rightTotal) ;
            total = Math.max(total, root.val+leftTotal+rightTotal) ;

            int localTotal = root.val ;
            localTotal = Math.max(localTotal, root.val+leftTotal) ;
            localTotal = Math.max(localTotal, root.val+rightTotal) ;
            return localTotal ;
        }
    }
}
