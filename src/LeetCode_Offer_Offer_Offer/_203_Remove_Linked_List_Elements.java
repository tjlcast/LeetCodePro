package LeetCode_Offer_Offer_Offer;

import Type.ListNode;

/**
 * Created by tangjialiang on 2018/1/18.
 */
public class _203_Remove_Linked_List_Elements {
    /**
     * Remove all elements from a linked list of integers that have value val.

     Example
     Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
     Return: 1 --> 2 --> 3 --> 4 --> 5
     */

    public static void main(String[] args) {
        ListNode head = null ;
        int val = 0 ;

        Solution solution = new Solution();
        ListNode listNode = solution.removeElements(head, val);

        System.out.println("The work is: " + listNode) ;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode root = new ListNode(-1) ;
            root.next = head ;
            ListNode node = root ;

            while(node!=null && node.next != null) {
                while (node.next!=null && node.next.val==val) {
                    removeTheNextElement(node);
                }
                node = node.next ;
            }

            return root.next ;
        }

        private void removeTheNextElement(ListNode node) {
            if (node==null || node.next==null) return ;

            ListNode next = node.next.next;
            node.next = next ;

            return ;
        }
    }
}
