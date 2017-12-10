package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/12/10.
 */
public class _144_Binary_Tree_Preorder_Traversal {
    /**
     * Given a binary tree, return the preorder traversal of its nodes' values.

     For example:
     Given binary tree [1,null,2,3],
     1
     \
     2
     /
     3
     return [1,2,3].
     */

    public static void main(String[] args) {

    }

    static class Solution {
        List<Integer> ans = new LinkedList<>() ;

        public List<Integer> preorderTraversal(TreeNode root) {
            preTravel(root);
            return ans ;
        }

        private void preTravel(TreeNode root) {
            if (root == null) return ;

            ans.add(root.val) ;

            preorderTraversal(root.left) ;
            preorderTraversal(root.right) ;
        }
    }
}
