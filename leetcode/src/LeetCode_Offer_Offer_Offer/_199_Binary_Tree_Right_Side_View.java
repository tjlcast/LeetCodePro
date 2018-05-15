package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2018/1/17.
 */
public class _199_Binary_Tree_Right_Side_View {
    /**
     * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

     For example:
     Given the following binary tree,
     1            <---
     /   \
     2     3         <---
     \     \
     5     4       <---
     You should return [1, 3, 4].
     */

    public static void main(String[] args) {

    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {
        private List<Integer> rightVals = new LinkedList<>() ;

        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) return rightVals ;
            bfs(root) ;
            return rightVals ;
        }

        private void bfs(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>() ;
            TreeNode tail = new TreeNode(-1) ;
            queue.add(root) ;
            queue.add(tail) ;

            while(queue.size() != 1) {
                TreeNode poll = queue.poll();
                if (poll == tail) {
                    queue.add(tail) ;
                    continue;
                }

                if (tail == queue.getFirst()) {
                    System.out.println(poll.val) ;
                    this.rightVals.add(poll.val) ;
                }
                if (poll.left != null) queue.add(poll.left) ;
                if (poll.right != null) queue.add(poll.right) ;
            }
        }
    }
}
