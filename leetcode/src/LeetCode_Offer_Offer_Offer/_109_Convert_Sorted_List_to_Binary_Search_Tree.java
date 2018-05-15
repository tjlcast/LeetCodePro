package LeetCode_Offer_Offer_Offer;

import Type.ListNode;
import Type.TreeNode;

/**
 * Created by tangjialiang on 2017/11/11.
 *
 */
public class _109_Convert_Sorted_List_to_Binary_Search_Tree {
    public static void main(String[] args) {

    }

    public TreeNode work(ListNode head) {
        Solution solution = new Solution();
        TreeNode treeNode = solution.sortedListToBST(head);
        return treeNode ;
    }

    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            return buildTree(head) ;
        }

        private TreeNode buildTree(ListNode head) {
            if (head == null) return null ;

            ListNode root = new ListNode(-1) ;
            root.next = head ;
            ListNode stepOne = root ;
            ListNode stepTwo = root ;

            int count = 0 ;
            while(stepTwo.next.next != null) {
                stepTwo = stepTwo.next ;
                stepOne = stepOne.next ;
                if (stepTwo.next.next != null) stepTwo = stepTwo.next ;
            }

            TreeNode treeNode = new TreeNode(stepOne.next.val) ;
            // split the list:
            stepOne.next = stepOne.next.next ;
            ListNode leftList = root.next ;
            ListNode rightList = stepOne.next ;
            stepOne.next = null ;

            treeNode.left = buildTree(leftList) ;
            treeNode.right = buildTree(rightList) ;

            return treeNode ;
        }
    }
}
