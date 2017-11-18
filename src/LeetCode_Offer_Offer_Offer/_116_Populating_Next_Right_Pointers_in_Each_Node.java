package LeetCode_Offer_Offer_Offer;

import Type.TreeLinkNode;

import java.util.LinkedList;

/**
 * Created by tangjialiang on 2017/11/18.
 */
public class _116_Populating_Next_Right_Pointers_in_Each_Node {

    public class Solution {
        public void connect(TreeLinkNode root) {
            if (root==null) return ;
            bfs(root) ;
        }

        private void bfs(TreeLinkNode root) {
            LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>() ;

            TreeLinkNode end = new TreeLinkNode(-1) ;
            queue.addLast(root) ;
            queue.addLast(end) ;

            TreeLinkNode lastNode = null ;
            while(queue.size()!=1) {
                TreeLinkNode node = queue.removeFirst() ;
                if (node == end) {
                    queue.addLast(node) ;
                    lastNode = null ;
                } else {
                    // link
                    node.next = lastNode ;
                    if(node.right!=null)queue.addLast(node.right) ;
                    if(node.left!=null)queue.addLast(node.left) ;
                    lastNode = node ;
                }
            }
        }
    }
}
