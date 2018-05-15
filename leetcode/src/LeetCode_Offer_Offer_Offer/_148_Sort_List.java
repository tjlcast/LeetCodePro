package LeetCode_Offer_Offer_Offer;

import Type.ListNode;

/**
 * Created by tangjialiang on 2017/12/12.
 */
public class _148_Sort_List {
    /**
     * Sort a linked list in O(n log n) time using constant space complexity.
     */

    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode sortList(ListNode head) {
            if (head==null) return null ;
            if (head.next == null) return head ;

            ListNode root = new ListNode(-1); root.next = head ;
            ListNode fast = root ;
            ListNode slow = root ;

            while(fast != null) {
                fast = fast.next ;
                if (fast==null) break ;
                slow = slow.next ;

                fast = fast.next ;
            }

            ListNode headA = root.next ;
            ListNode headB = slow.next ;
            slow.next = null ;

            headA = sortList(headA) ;
            headB = sortList(headB) ;

            return merge(headA, headB) ;
        }

        private ListNode merge(ListNode headA, ListNode headB) {
            ListNode rootA = new ListNode(-1); rootA.next = headA ;
            ListNode rootB = new ListNode(-1); rootB.next = headB ;

            ListNode root = new ListNode(-1) ;
            ListNode tail = root ;
            while(rootA.next!=null || rootB.next!=null) {
                int valA = Integer.MAX_VALUE ;
                int valB = Integer.MAX_VALUE ;
                ListNode node = null ;
                if (rootA.next!=null) valA = rootA.next.val ;
                if (rootB.next!=null) valB = rootB.next.val ;

                if(valA < valB) {
                    node = rootA.next ;
                    rootA.next = rootA.next.next ;
                } else {
                    node = rootB.next ;
                    rootB.next = rootB.next.next ;
                }

                tail.next = node ;
                tail = node ;
                tail.next = null ;
            }

            return root.next ;
        }
    }
}
