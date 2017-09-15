package LeetCode_Offer_Offer_Offer;

import Type.ListNode;
import Utils.LinkedListUtils;

import java.util.List;

/**
 * Created by tangjialiang on 2017/9/14.
 */
public class _83_Remove_Duplicates_from_Sorted_List {
    /**
     * Given a sorted linked list, delete all duplicates such that each element appear only once.

     For example,
     Given 1->1->2, return 1->2.
     Given 1->1->2->3->3, return 1->2->3.
     */

    public static void main(String[] args) {
        ListNode head = null ;

        _83_Remove_Duplicates_from_Sorted_List remove_duplicates_from_sorted_list = new _83_Remove_Duplicates_from_Sorted_List();
        ListNode work = remove_duplicates_from_sorted_list.work(head);

        System.out.println("work is: ") ;
        new LinkedListUtils<ListNode>(ListNode.class).printLinkedList(work);
    }

    public ListNode work(ListNode head) {
        Solution solution = new Solution();
        ListNode listNode = solution.deleteDuplicates(head);

        return listNode ;
    }

    class Solution {
        private ListNode root = new ListNode(-1) ;
        private ListNode tail = root ;

        public ListNode deleteDuplicates(ListNode head) {
            while(head != null) {
                int val = head.val ;

                tail.next = head ;
                head = head.next ;
                tail = tail.next ;
                tail.next = null ;

                while(head!=null && head.val==val) {
                    head = head.next ;
                }
            }

            return root.next ;
        }
    }
}
