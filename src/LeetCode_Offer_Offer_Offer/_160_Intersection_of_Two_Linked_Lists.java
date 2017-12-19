package LeetCode_Offer_Offer_Offer;

import Type.ListNode;

/**
 * Created by tangjialiang on 2017/12/19.
 */
public class _160_Intersection_of_Two_Linked_Lists {

    /**
     * Write a program to find the node at which the intersection of two singly linked lists begins.
     * @param args
     */

    public static void main(String[] args) {
        ListNode headA = null ;
        ListNode headB = null ;

        Solution solution = new Solution();
        ListNode intersectionNode = solution.getIntersectionNode(headA, headB);
    }

    static public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {


            ListNode stepA = headA ;
            int stepANum = 0 ;
            while(stepA != null) {
                stepANum++ ;
                stepA = stepA.next ;
            }

            ListNode stepB = headB ;
            int stepBNum = 0 ;
            while(stepB != null) {
                stepBNum++ ;
                stepB = stepB.next ;
            }

            ListNode rootA = new ListNode(-1);
            ListNode rootB = new ListNode(-1);
            int diffNum = Math.abs(stepANum - stepBNum) ;
            if(stepANum > stepBNum) {
                rootA.next = headA ;
                rootB.next = headB ;
            } else {
                rootA.next = headB ;
                rootB.next = headA ;
            }
            while(diffNum > 0) {
                rootA.next = rootA.next.next ;
                diffNum-- ;
            }

            while(rootA.next != null) {
                if(rootA.next == rootB.next) {
                    return rootA.next ;
                }
                rootA.next = rootA.next.next ;
                rootB.next = rootB.next.next ;
            }

            return null ;
        }
    }
}
