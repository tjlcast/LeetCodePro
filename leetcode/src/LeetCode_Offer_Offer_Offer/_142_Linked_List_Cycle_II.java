package LeetCode_Offer_Offer_Offer;

import Type.ListNode;

/**
 * Created by tangjialiang on 2017/12/7.
 */
public class _142_Linked_List_Cycle_II {
    /**
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

     Note: Do not modify the linked list.
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = solution.detectCycle(null);
    }

    static public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) return null ;

            ListNode ind1 = head ;
            ListNode ind2 = head ;

            while(ind1!=null && ind2!=null) {
                ind2 = ind2.next ;
                if (ind2!=null) ind2 = ind2.next ;

                ind1 = ind1.next ;

                if (ind1 == ind2) break ;
            }

            if (ind2 != null && ind2==ind1) {
                ListNode node1 = ind2 ;
                ListNode node2 = head ;

                while(node1 != node2) {
                    node1 = node1.next ;
                    node2 = node2.next ;
                }
                return node1 ;
            }

            return null ;
        }
    }
}
