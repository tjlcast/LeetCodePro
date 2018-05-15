package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

/**
 * Created by tangjialiang on 2017/11/18.
 */
public class _114_Flatten_Binary_Tree_to_Linked_List {

    class Solution {
        /**
         each node has two children trees.
         just sort left trees before right trees.
         pro: how to link the left trees and right trees.
         **/
        public void flatten(TreeNode root) {
            dfs(root) ;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return ;
            }

            TreeNode leftT = root.left ;
            TreeNode rightT = root.right ;

            if (leftT != null) {
                TreeNode rLastT = findRLast(leftT) ;

                root.right = leftT ;
                root.left = null ;
                rLastT.right = rightT ;
            }

            dfs(root.right) ;
        }

        private TreeNode findRLast(TreeNode root) {
            // root must not be null
            while(root.right != null) {
                root = root.right ;
            }
            return root ;
        }
    }
}
