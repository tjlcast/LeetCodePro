package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

/**
 * Created by tangjialiang on 2018/1/29.
 */
public class _235__Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

    public static void main(String[] args) {
        TreeNode root = null ;
        TreeNode a = null ;
        TreeNode b = null ;

        Solution sol = new Solution() ;
        TreeNode node = sol.lowestCommonAncestor(root, a, b) ;

        System.out.println("The work is: ") ;
    }

    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return root ;

            int val = root.val ;

            if (p.val<val && q.val<val) return lowestCommonAncestor(root.left, p, q) ;
            else if (p.val>val && q.val>val) return lowestCommonAncestor(root.right, p, q) ;
            else return root ;
        }
    }
}
