package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/12/10.
 */
public class _145_Binary_Tree_Postorder_Traversal {
    /**
     * Given a binary tree, return the postorder traversal of its nodes' values.

     For example:
     Given binary tree {1,#,2,3},
     1
     \
     2
     /
     3
     return [3,2,1].
     */

    public static void main(String[] args) {

    }

    static class Solution {
        List<Integer> ans = new LinkedList<>() ;

        public List<Integer> postorderTraversal(TreeNode root) {
            postTravel(root) ;
            return ans ;
        }

        private void postTravel(TreeNode root) {
            if (root == null) return ;

            postorderTraversal(root.left) ;
            postorderTraversal(root.right) ;
            ans.add(root.val) ;
        }
    }
}
