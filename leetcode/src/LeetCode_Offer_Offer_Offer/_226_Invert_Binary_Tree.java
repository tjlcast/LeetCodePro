package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

/**
 * Created by tangjialiang on 2018/1/25.
 */
public class _226_Invert_Binary_Tree {

    public static void main(String[] args) {

    }

    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return root ;

            root.left = invertTree(root.left) ;
            root.right = invertTree(root.right) ;
            TreeNode tmpNode = root.left ;
            root.left = root.right ;
            root.right = tmpNode ;

            return root ;
        }
    }
}
