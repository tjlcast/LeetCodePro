package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

/**
 * Created by tangjialiang on 2017/11/18.
 */
public class _111_Minimum_Depth_of_Binary_Tree {

    class Solution {
        int minDepth = Integer.MAX_VALUE ;

        public int minDepth(TreeNode root) {
            if (root == null) return 0 ;

            findMinDepth(root, 1) ;
            return minDepth ;
        }

        private void findMinDepth(TreeNode root, int curDepth) {
            if (root.left==null && root.right==null) {
                minDepth = Math.min(minDepth, curDepth) ;
            }

            if (curDepth > minDepth) return ; //

            if (root.left!=null) findMinDepth(root.left, curDepth+1) ;
            if (root.right!=null) findMinDepth(root.right, curDepth+1) ;

            return ;
        }

    }
}
