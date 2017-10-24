package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

/**
 * Created by tangjialiang on 2017/10/24.
 */
public class _104_Maximum_Depth_of_Binary_Tree {
    public static void main(String[] args) {

    }

    public int work(TreeNode root) {
        Solution solution = new Solution();
        int i = solution.maxDepth(root);

        return i ;
    }

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0 ;

            int maxChildrenDepth = maxDepth(root.left) ;
            maxChildrenDepth = Math.max(maxChildrenDepth, maxDepth(root.right)) ;

            int depth = maxChildrenDepth + 1 ;
            return depth ;
        }
    }
}
