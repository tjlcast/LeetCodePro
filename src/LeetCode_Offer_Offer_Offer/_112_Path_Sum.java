package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

/**
 * Created by tangjialiang on 2017/11/18.
 */
public class _112_Path_Sum {

    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root==null) {
                return false ;
            }
            boolean ans = pathSum(root, sum) ;
            return ans ;
        }

        private boolean pathSum(TreeNode root, int sum) {
            if (root.left == null && root.right==null) {
                // is leaf
                if (root.val == sum) return true ;
                return false ;
            }

            boolean ans = false ;
            if (root.left != null) {
                ans = ans || pathSum(root.left, sum - root.val) ;
                if (ans) return ans ;
            }
            if (root.right != null) {
                ans = ans || pathSum(root.right, sum - root.val) ;
                if (ans) return ans ;
            }

            return ans ;
        }
    }
}
