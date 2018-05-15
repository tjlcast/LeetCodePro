package LeetCode_Offer_Offer_Offer;

import Type.ListNode;
import Utils.LinkedListUtils;

/**
 * Created by tangjialiang on 2017/9/20.
 */
public class _92_Reverse_Linked_List_II {
    /**
     * Reverse a linked list from position m to n. Do it in-place and in one-pass.

     For example:
     Given 1->2->3->4->5->NULL, m = 2 and n = 4,

     return 1->4->3->2->5->NULL.

     Note:
     Given m, n satisfy the following condition:
     1 ≤ m ≤ n ≤ length of list.
     */

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5} ;
        int m = 2 ;
        int n = 4 ;
        ListNode listNode = new LinkedListUtils<ListNode>(ListNode.class).buildLinkedList(arr);

        _92_Reverse_Linked_List_II reverse_linked_list_ii = new _92_Reverse_Linked_List_II();
        ListNode work = reverse_linked_list_ii.work(listNode, 2, 4);

        System.out.println("work is: " ) ;
        new LinkedListUtils<ListNode>(ListNode.class).printLinkedList(work);
    }

    public ListNode work(ListNode head, int m, int n) {
        Solution solution = new Solution();
        ListNode listNode = solution.reverseBetween(head, m, n);
        return listNode ;
    }

    class Solution {
        private ListNode root = new ListNode(-1) ;
        private int m = -1 ;
        private int n = -1 ;

        public ListNode reverseBetween(ListNode head, int m, int n) {
            this.m = m ;
            this.n = n ;
            root.next = head ;

            doReverse(root) ;

            return root.next ;
        }

        private void doReverse(ListNode root) {
            int i = 0 ;
            ListNode ptr = root ;

            while(i < m-1) {ptr = ptr.next; i++; }
            ListNode lastTail = ptr ;
            ptr = ptr.next ;
            i++ ;

            // ptr is (m)'s node
            ListNode newRoot = new ListNode(-1) ;
            ListNode newTail = null ;
            while(i <= n) {
                ListNode addNode = ptr ;
                ptr = ptr.next ;
                i++ ;
                if (newTail == null) {newRoot.next = addNode; newTail = addNode; }
                else {addNode.next = newRoot.next; newRoot.next = addNode; }
            }

            // ptr is (n+1)'s node

            lastTail.next = newRoot.next ;
            newTail.next = ptr ;
        }
    }
}
