package LeetCode_Offer_Offer_Offer;

import Type.ListNode;

/**
 * Created by tangjialiang on 2017/12/7.
 */
public class _141_Linked_List_Cycle {
    /**
     * Given a linked list, determine if it has a cycle in it.

     Follow up:
     Can you solve it without using extra space?
     */

    public static void main(String[] args) {

    }

    static public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) return false ;

            ListNode root = new ListNode(-1) ;
            root.next = head ;
            ListNode ind1 = root ;
            ListNode ind2 = root ;

            do {
                ind1 = ind1.next ;

                ind2 = ind2.next ;
                if (ind2!=null) ind2 = ind2.next ;

                if (ind1 == ind2) return true ;

            } while (ind2 != null) ;

            return false ;
        }
    }
}
