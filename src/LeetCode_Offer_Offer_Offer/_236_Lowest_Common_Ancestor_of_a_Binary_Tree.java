package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

/**
 * Created by tangjialiang on 2018/1/29.
 */
public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree {

    public static void main(String[] args) {
        TreeNode root = null ;
        TreeNode p = null ;
        TreeNode q = null ;

        Solution sol = new Solution() ;
        TreeNode ans = sol.lowestCommonAncestor(root, p, q) ;

        System.out.println("The work is: ") ;
    }

    static class Solution {
        private final int P_MASTER = 2 ;
        private final int Q_MASTER = 1 ;

        TreeNode ans = null ;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return root ;

            postDfs(root, p, q) ;
            return ans ;
        }

        public int postDfs(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return 0 ;

            int nodeAns = 0 ;
            if (ans==null)nodeAns = nodeAns | postDfs(root.left, p, q) ;
            if (ans==null)nodeAns = nodeAns | postDfs(root.right, p, q) ;

            if (root == p) nodeAns = nodeAns | P_MASTER ;
            if (root == q) nodeAns = nodeAns | Q_MASTER ;

            if ((nodeAns&P_MASTER)!=0 && (nodeAns&Q_MASTER)!=0 && ans==null) ans = root ;

            return nodeAns ;
        }
    }
}
