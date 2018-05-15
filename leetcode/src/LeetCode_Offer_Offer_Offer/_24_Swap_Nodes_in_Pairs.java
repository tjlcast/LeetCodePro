package LeetCode_Offer_Offer_Offer;

import Type.ListNode;

/**
 * Created by tangjialiang on 2017/9/2.
 */
public class _24_Swap_Nodes_in_Pairs {
    /**
     * Given a linked list, swap every two adjacent nodes and return its head.

     For example,
     Given 1->2->3->4, you should return the list as 2->1->4->3.

     Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
     */

    public static void main(String[] args) {

    }

    public ListNode work(ListNode head) {
        Solution solution = new Solution();
        ListNode listNode = solution.swapPairs(head);
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
        private ListNode ans = new ListNode(-1) ;
        private ListNode ansTail = ans ;

        public ListNode swapPairs(ListNode head) {

            while(head != null) {
                ListNode a = null ;
                ListNode b = null ;

                if (head != null) {
                    a = head ;
                    head = head.next ;
                }
                if (head!=null ) {
                    b=head ;
                    head = head.next ;
                }

                if (b != null) {
                    ansTail.next = b ;
                    b.next = null ;
                    ansTail = ansTail.next ;
                }

                if (a!=null) {
                    ansTail.next = a ;
                    a.next = null ;
                    ansTail = ansTail.next ;
                }

            }

            return ans.next ;
        }
    }
}
