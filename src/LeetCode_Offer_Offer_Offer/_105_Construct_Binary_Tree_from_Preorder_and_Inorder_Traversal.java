package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

/**
 * Created by tangjialiang on 2017/10/24.
 */
public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    public static void main(String[] args) {
        int[] preorder = {1,2,4,3} ;
        int[] inorder = {1,2,3,4} ;

        _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal construct_binary_tree_from_preorder_and_inorder_traversal = new _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
        TreeNode work = construct_binary_tree_from_preorder_and_inorder_traversal.work(preorder, inorder);


    }

    public TreeNode work(int[] preorder, int[] inorder) {
        Solution sol = new Solution() ;
        TreeNode treeNode = sol.buildTree(preorder, inorder);

        return treeNode ;
    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            TreeNode node = construct(preorder, 0, preorder.length, inorder, 0, inorder.length) ;
            return node ;
        }

        private TreeNode construct(int[] preorder, int ps, int plen, int[] inorder, int is, int ilen) {
            if (plen <= 0) {
                return null ;
            }

            int val = preorder[ps] ;
            TreeNode node = new TreeNode(val) ;

            int pos = is ;
            while(pos<is+ilen && inorder[pos]!=val) {
                pos++ ;
            }

            int len1 = pos - is ;
            int len2 = ilen - (pos - is + 1) ;
            System.out.format("val : %d len1 : %d len2 : %d\n", val, len1, len2) ;

            node.left = construct(preorder, ps+1, len1, inorder, is, len1) ;
            node.right = construct(preorder, ps+len1+1, len2, inorder, pos+1, len2) ;

            return node ;
        }
    }
}

