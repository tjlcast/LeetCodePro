package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

/**
 * Created by tangjialiang on 2017/10/25.
 */
public class _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public static void main(String[] args) {
        int[] inorder = {1,2,4,3} ;
        int[] postorder = {1,2,3,4} ;

        _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal construct_binary_tree_from_inorder_and_postorder_traversal = new _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
        construct_binary_tree_from_inorder_and_postorder_traversal.work(inorder, postorder) ;
    }


    public TreeNode work(int[] inorder, int[] postorder) {
        Solution solution = new Solution();
        TreeNode treeNode = solution.buildTree(inorder, postorder);

        return treeNode ;
    }


    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return construct(inorder, 0, inorder.length, postorder, 0, postorder.length) ;
        }

        private TreeNode construct(int[] inorder, int rs, int rlen, int[] postorder, int os, int olen) {
            if (rlen <= 0) {
                return null;
            }

            int val = postorder[os + olen - 1];
            TreeNode node = new TreeNode(val);

            int pos = rs;
            while (pos < rs + rlen && inorder[pos] != val) {
                pos++;
            }

            int len1 = pos - rs;
            int len2 = rlen - (pos - rs + 1);
            //System.out.format("val : %d len1 : %d len2 : %d\n", val, len1, len2);

            node.left = construct(inorder, rs, len1, postorder, os, len1);
            node.right = construct(inorder, pos + 1, len2, postorder, os + len1, len2);

            return node;
        }
    }
}
