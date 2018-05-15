package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

/**
 * Created by tangjialiang on 2017/9/23.
 */
public class _100_Same_Tree {
    /**
     * Given two binary trees, write a function to check if they are equal or not.

     Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
     */

    public static void main(String[] args) {

    }

    public boolean work(TreeNode p, TreeNode q) {
        Solution solution = new Solution();
        boolean sameTree = solution.isSameTree(p, q);

        return sameTree ;
    }

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p==null && q==null) return true ;
            if (p==null && q!=null) return false ;
            if (p!=null && q==null) return false ;

            if (p.val != q.val) return false ;
            System.out.format("p is: %d q is: %d\n", p.val, q.val) ;

            boolean leftAns = isSameTree(p.left, q.left) ;
            if (!leftAns) return false ;
            boolean rightAns = isSameTree(p.right, q.right) ;
            if (!rightAns) return false ;

            return true ;
        }
    }
}
