package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/21.
 */
public class _94_Binary_Tree_Inorder_Traversal {

    /**
     * Given a binary tree, return the inorder traversal of its nodes' values.

     For example:
     Given binary tree [1,null,2,3],
     1
     \
     2
     /
     3
     return [1,3,2].
     */

    public static void main(String[] args) {

    }

    public List<Integer> work(TreeNode root) {
        Solution solution = new Solution();
        List<Integer> integers = solution.inorderTraversal(root);

        return integers ;
    }

    class Solution {
        private List<Integer> ans = new LinkedList<>() ;

        public List<Integer> inorderTraversal(TreeNode root) {
            travel(root);

            return ans ;
        }

        private void travel(TreeNode root) {
            if (root == null) return ;

            travel(root.left) ;
            ans.add(root.val) ;
            travel(root.right) ;

            return ;
        }
    }
}
