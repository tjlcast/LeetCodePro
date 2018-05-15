package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

/**
 * Created by tangjialiang on 2018/1/28.
 */
public class _230_Kth_Smallest_Element_in_a_BST {

    public static void main(String[] args) {

    }

    class Solution {
        int k ;
        int curK = 0;
        TreeNode curNode = null ;
        TreeNode ans = null ;

        public int kthSmallest(TreeNode root, int k) {
            this.k = k ;
            inOrder(root) ;
            if (ans == null) return curNode.val ;
            return ans.val ;
        }

        private void inOrder(TreeNode root) {
            if (root == null) return ;

            inOrder(root.left) ;
            curK += 1;
            curNode = root ;
            if (curK == k) ans = curNode ;
            inOrder(root.right) ;
        }
    }
}
