package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2017/11/18.
 */
public class _110_Balanced_Binary_Tree {

    class Solution {
        HashMap<TreeNode, Integer> recorders = new HashMap<TreeNode, Integer>() ;

        public boolean isBalanced(TreeNode root) {
            if (root == null) return true ;

            boolean leftIs = isBalanced(root.left) ;  if (!leftIs) return false ;
            boolean rightIs = isBalanced(root.right) ;  if (!rightIs) return false ;

            int leftHeight = getHeight(root.left) ;
            int rightHeight = getHeight(root.right) ;
            if (Math.abs(leftHeight - rightHeight)>=2) {
                return false ;
            }
            return true ;

        }

        private int getHeight(TreeNode root) {
            if (recorders.containsKey(root)) {
                return recorders.get(root) ;
            }
            if (root == null) return 0 ;

            int leftHeight = getHeight(root.left) ;
            int rightHeight = getHeight(root.right) ;

            int childHeight = Math.max(leftHeight, rightHeight) ;
            return childHeight+1 ;
        }
    }
}
