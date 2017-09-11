package LeetCode_Offer_Offer_Offer;

import Type.ListNode;
import Utils.LinkedListUtils;

/**
 * Created by tangjialiang on 2017/9/10.
 */
public class _61_Rotate_List {
    /**
     * Given a list, rotate the list to the right by k places, where k is non-negative.

     For example:
     Given 1->2->3->4->5->NULL and k = 2,
     return 4->5->1->2->3->NULL.
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5} ;
        int k = 1 ;
        ListNode listNode = new LinkedListUtils<ListNode>(ListNode.class).buildLinkedList(nums);

        ListNode work = new _61_Rotate_List().work(listNode, k);

        System.out.println("work is: ") ;
        new LinkedListUtils<ListNode>(ListNode.class).printLinkedList(work);
    }

    public ListNode work(ListNode head, int k) {
        Solution solution = new Solution();
        ListNode listNode = solution.rotateRight(head, k);

        return listNode ;
    }

    class Solution {
        private ListNode root = new ListNode(-1) ;
        private int len = 0 ;

        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) return head ;

            // pre work
            root.next = head ;
            ListNode tail = root ;
            while(tail.next != null) {tail = tail.next; len++; }
            tail.next = root.next ;

            // rotate the cycle
            for(int i=0; i<len-(k%len+1)+1; i++) {
                root.next = root.next.next ;
            }

            tail = root ;
            for(int i=0; i<len; i++) {tail = tail.next; }
            tail.next = null ;

            return root.next ;
        }
    }
}
