package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;
import java.util.* ;
import java.io.* ;

/**
 * Created by tangjialiang on 2017/10/29.
 *
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */


public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8} ;
        _108_Convert_Sorted_Array_to_Binary_Search_Tree convert_sorted_array_to_binary_search_tree = new _108_Convert_Sorted_Array_to_Binary_Search_Tree();
        TreeNode work = convert_sorted_array_to_binary_search_tree.work(nums);

        System.out.println("work is: ") ;
        _108_Convert_Sorted_Array_to_Binary_Search_Tree.printTree(work);
    }

    static void printTree(TreeNode root) {
        if (root == null) return ;

        printTree(root.left);
        System.out.println(root.val) ;
        printTree(root.right);
    }


    public TreeNode work(int[] nums) {
        Solution convert_sorted_array_to_binary_search_tree = new Solution();
        TreeNode treeNode = convert_sorted_array_to_binary_search_tree.sortedArrayToBST(nums);
        return treeNode ;
    }


    class Solution {

        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums==null || nums.length==0) return null ;

            TreeNode root = buildBST(nums, 0, nums.length-1) ;

            return root ;
        }

        private TreeNode buildBST(int[] nums, int s, int e) {
            if (s > e) return null ;

            int pos = (s + e) / 2 ;
            int val = nums[pos] ;
            TreeNode root = new TreeNode(val) ;

            if (s == e) return root ;

            root.left = buildBST(nums, s, pos-1) ;
            root.right = buildBST(nums, pos+1, e) ;
            return root ;
        }
    }

}
