package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by tangjialiang on 2017/9/25.
 */
public class _99_Recover_Binary_Search_Tree {
    /**
     * Two elements of a binary search tree (BST) are swapped by mistake.

     Recover the tree without changing its structure.

     Note:
     A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
     */

    public static void main(String[] args) {
        Integer[] arrays = {1,2,3,4,5};
        List<Integer> list = Arrays.asList(arrays);
        list.stream().map(it->it*2).forEach(System.out::println);

        _99_Recover_Binary_Search_Tree recover_binary_search_tree = new _99_Recover_Binary_Search_Tree();
        recover_binary_search_tree.work(null);

        System.out.println("work is: ") ;
    }

    public void work(TreeNode root) {
        Solution solution = new Solution();
        solution.recoverTree(root);
    }

    class Solution {
        private boolean go = true ;

        private TreeNode nodeA = null ;
        private TreeNode preMaxNodeFirst = null ;

        private TreeNode nodeB = null ;
        private TreeNode preMaxNodeSecon = null ;

        public void recoverTree(TreeNode root) {
            go = true ;
            inOrderTravelFirst(root);
            go = true ;
            inOrderTravelSecon(root);

            if (nodeB!=null && nodeA!=null) {
                int temp = nodeA.val ;
                nodeA.val = nodeB.val ;
                nodeB.val= temp ;
            }
        }

        private void inOrderTravelFirst(TreeNode root) {
            if (root == null) return;

            if(go)inOrderTravelFirst(root.left);
            // work
            if(!go) return ;
            if (preMaxNodeFirst==null) preMaxNodeFirst = root ;
            else {
                if (preMaxNodeFirst.val > root.val) {
                    nodeA = preMaxNodeFirst ;
                    go = false ;
                }
                preMaxNodeFirst = root ;
            }
            if(go)inOrderTravelFirst(root.right);

            return ;
        }

        private void inOrderTravelSecon(TreeNode root) {
            if (root == null) return ;

            if (go)inOrderTravelSecon(root.right) ;

            // work
            if(!go) return ;
            if (preMaxNodeSecon==null) preMaxNodeSecon = root ;
            else {
                if (preMaxNodeSecon.val < root.val) {
                    nodeB = preMaxNodeSecon ;
                    go = false ;
                }
                preMaxNodeSecon = root ;
            }
            if (go)inOrderTravelSecon(root.left);

            return ;
        }
    }
}
