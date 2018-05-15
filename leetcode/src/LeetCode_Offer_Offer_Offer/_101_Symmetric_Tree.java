package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

public class _101_Symmetric_Tree {
    /**
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

     For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

     1
     / \
     2   2
     / \ / \
     3  4 4  3
     But the following [1,2,2,null,3,null,3] is not:
     1
     / \
     2   2
     \   \
     3    3
     Note:
     Bonus points if you could solve it both recursively and iteratively.
     */

    public static void main(String[] args) {
        _101_Symmetric_Tree symmetric_tree = new _101_Symmetric_Tree();

    }

    public boolean work(TreeNode root) {
        Solution solution = new Solution();
        boolean symmetric = solution.isSymmetric(root);

        return symmetric ;
    }

    class Solution {

        public boolean isSymmetric(TreeNode root) {
            return twoPointersSame(root, root) ;
        }

        private boolean twoPointersSame(TreeNode root1, TreeNode root2) {
            if (root1==null && root2==null) return true ;
            if (root1==null && root2!=null) return false ;
            if (root1!=null && root2==null) return false ;

            if (root1.val != root2.val) { return false ; }

            // for out
            boolean ans1 = twoPointersSame(root1.left, root2.right) ;
            if (!ans1) return false ;

            // for out
            boolean ans2 = twoPointersSame(root1.right, root2.left) ;
            if (!ans2) return false ;

            return true ;
        }
    }
}
