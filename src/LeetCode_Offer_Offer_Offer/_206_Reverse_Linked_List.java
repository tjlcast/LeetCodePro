package LeetCode_Offer_Offer_Offer;

import Type.ListNode;

/**
 * Created by tangjialiang on 2018/1/18.
 */
public class _206_Reverse_Linked_List {

    public static void main(String[] args) {
        ListNode head = null ;

        Solution solution = new Solution();
        ListNode listNode = solution.reverseList(head);

        System.out.println("The work is: ") ;
        while(listNode != null) {
            System.out.println(listNode.val) ;
            listNode = listNode.next ;
        }
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
        public ListNode reverseList(ListNode head) {
            ListNode root = new ListNode(-1) ;

            while(head != null) {
                ListNode node = head ;
                head = head.next ;

                node.next = root.next ;
                root.next = node ;
            }

            return root.next ;
        }
    }
}
