package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

/**
 * Created by tangjialiang on 2017/9/21.
 */
public class _98_Validate_Binary_Search_Tree {
    /**
     * Given a binary tree, determine if it is a valid binary search tree (BST).

     Assume a BST is defined as follows:

     The left subtree of a node contains only nodes with keys less than the node's key.
     The right subtree of a node contains only nodes with keys greater than the node's key.
     Both the left and right subtrees must also be binary search trees.
     Example 1:
     2
     / \
     1   3
     Binary tree [2,1,3], return true.
     Example 2:
     1
     / \
     2   3
     Binary tree [1,2,3], return false.
     */

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        Solution solution = new Solution();
        boolean validBST = solution.isValidBST(root);

        return validBST ;
    }

    class Solution {
        private boolean leftValid = true ;
        private boolean rightValid = true ;

        public boolean isValidBST(TreeNode root) {
            if (root==null) return true ;

            leftTreeJudge(root) ;
            rightTreeJudge(root) ;

            return (leftValid && rightValid) ;
        }

        private int leftTreeJudge(TreeNode root) {
            // return the max value of current tree
            int max = root.val ;

            if(leftValid && root.left!=null){
                int leftVal = leftTreeJudge(root.left) ;
                max = Math.max(max, leftVal) ;
                if (leftVal>=root.val) {
                    leftValid = false ;
                }
            }
            if(leftValid && root.right!=null){
                int rightVal = leftTreeJudge(root.right) ;
                max = Math.max(max, rightVal) ;
            }

            return max ;
        }

        private int rightTreeJudge(TreeNode root) {
            // return the max value of current tree

            int min = root.val ;

            if(rightValid && root.left!=null){
                int leftVal = rightTreeJudge(root.left) ;
                min = Math.min(min, leftVal) ;
            }
            if(rightValid && root.right!=null){
                int rightVal = rightTreeJudge(root.right) ;
                min = Math.min(min, rightVal) ;
                if (root.val >= rightVal) {
                    rightValid = false ;
                }
            }

            return min ;
        }


    }
}
