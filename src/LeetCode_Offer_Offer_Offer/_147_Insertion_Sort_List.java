package LeetCode_Offer_Offer_Offer;

import Type.ListNode;

/**
 * Created by tangjialiang on 2017/12/12.
 */
public class _147_Insertion_Sort_List {

    /**
     * Sort a linked list using insertion sort.
     */

    public static void main(String[] args) {

    }

    static class Solution {
        ListNode root = new ListNode(-1) ;

        public ListNode insertionSortList(ListNode head) {
            while(head != null) {
                ListNode node = head ;
                head = head.next ;
                addNode(node);
            }

            return root.next ;
        }

        private void addNode(ListNode node) {
            ListNode tail = root ;
            while(tail.next!=null && tail.next.val<node.val) {
                tail = tail.next ;
            }

            node.next = tail.next ;
            tail.next = node ;
        }
    }
}
