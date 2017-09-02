package LeetCode_Offer_Offer_Offer;

import Type.ListNode;
import Utils.LinkedListUtils;

import java.util.LinkedList;

/**
 * Created by tangjialiang on 2017/9/2.
 */
public class _19_Remove_Nth_Node_From_End_of_List {
    /**
     * Given a linked list, remove the nth node from the end of list and return its head.

     For example,

     Given linked list: 1->2->3->4->5, and n = 2.

     After removing the second node from the end, the linked list becomes 1->2->3->5.
     Note:
     Given n will always be valid.
     Try to do this in one pass.
     */

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5} ;
        int n = 1 ;
        ListNode listNode = new LinkedListUtils<ListNode>(ListNode.class).buildLinkedList(nodes);
        _19_Remove_Nth_Node_From_End_of_List remove_nth_node_from_end_of_list = new _19_Remove_Nth_Node_From_End_of_List();
        ListNode work = remove_nth_node_from_end_of_list.work(listNode, n);

        System.out.println("work is: ") ;
        new LinkedListUtils<ListNode>(ListNode.class).printLinkedList(work);
    }

    public ListNode work(ListNode head, int n) {
        Solution solution = new Solution();
        ListNode listNode = solution.removeNthFromEnd(head, n);
        return listNode ;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (n==0) return head ;

            ListNode root = new ListNode(-1) ;
            root.next = head ;

            ListNode firstP = root ;
            ListNode secondP = root ;

            for(int i=0; i<n && head!=null; i++) {
                firstP = firstP.next ;
            }

            while(firstP!=null && firstP.next !=null) {
                firstP = firstP.next ;
                secondP = secondP.next ;
            }

            secondP.next = secondP.next.next ;
            return root.next ;
        }
    }
}
