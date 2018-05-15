package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

import java.util.LinkedList;

/**
 * Created by tangjialiang on 2017/12/28.
 */
public class _173_Binary_Search_Tree_Iterator {
    /**
     * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

     Calling next() will return the next smallest number in the BST.

     Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
     */

    /**
     * Your BSTIterator will be called like this:
     * BSTIterator i = new BSTIterator(root);
     * while (i.hasNext()) v[f()] = i.next();
     */

    public class BSTIterator {

        private TreeNode root ;
        private LinkedList<TreeNode> queue = new LinkedList<>() ;

        public BSTIterator(TreeNode root) {
            this.root = root ;

            TreeNode leftNode = root ;
            while(leftNode != null) {
                queue.addLast(leftNode);
                leftNode = leftNode.left ;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return queue.size()!=0 ;
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode lastNode = queue.removeLast();

            TreeNode leftNode = lastNode.right ;
            while(leftNode != null) {
                queue.addLast(leftNode);
                leftNode = leftNode.left ;
            }
            return lastNode.val ;
        }
    }
}
