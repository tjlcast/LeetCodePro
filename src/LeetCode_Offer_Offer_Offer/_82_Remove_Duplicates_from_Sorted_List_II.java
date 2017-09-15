package LeetCode_Offer_Offer_Offer;

import Type.ListNode;
import Utils.LinkedListUtils;

/**
 * Created by tangjialiang on 2017/9/14.
 */
public class _82_Remove_Duplicates_from_Sorted_List_II {
    /**
     * Given a sorted linked list, delete all nodes that have duplicate numbers,
     * leaving only distinct numbers from the original list.

     For example,
     Given 1->2->3->3->4->4->5, return 1->2->5.
     Given 1->1->1->2->3, return 2->3.
     */

    public static void main(String[] args) {
        ListNode head = null ;

        _82_Remove_Duplicates_from_Sorted_List_II remove_duplicates_from_sorted_list_ii = new _82_Remove_Duplicates_from_Sorted_List_II();
        ListNode work = remove_duplicates_from_sorted_list_ii.work(head);

        System.out.println("work is: ") ;
        new LinkedListUtils<ListNode>(ListNode.class).printLinkedList(work);
    }

    public ListNode work(ListNode head) {
        Solution solution = new Solution();
        ListNode listNode = solution.deleteDuplicates(head);

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
        private ListNode root = new ListNode(-1) ;
        private ListNode tail = root ;

        public ListNode deleteDuplicates(ListNode head) {

            while(head != null) {
                int val = head.val;
                if (head.next!= null && head.next.val==val) {
                    while(head != null && head.val==val) {head = head.next; }
                } else {
                    tail.next = head ;
                    head = head.next ;
                    tail = tail.next ;
                    tail.next = null ;
                }
            }

            return root.next ;
        }
    }
}
