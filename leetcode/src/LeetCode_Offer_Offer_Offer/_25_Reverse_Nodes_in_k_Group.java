package LeetCode_Offer_Offer_Offer;

import Type.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by tangjialiang on 2017/9/2.
 */
public class _25_Reverse_Nodes_in_k_Group {
    /**
     * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

     k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

     You may not alter the values in the nodes, only nodes itself may be changed.

     Only constant memory is allowed.

     For example,
     Given this linked list: 1->2->3->4->5

     For k = 2, you should return: 2->1->4->3->5

     For k = 3, you should return: 3->2->1->4->5
     */

    public static void main(String[] args) {

    }

    public ListNode work(ListNode head, int k) {
        Solution solution = new Solution();
        ListNode listNode = solution.reverseKGroup(head, k);
        return listNode ;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;s
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        private ListNode ans = new ListNode(-1) ;
        private ListNode ansTail = ans ;

        public ListNode reverseKGroup(ListNode head, int k) {
            Stack<ListNode> kNodes = new Stack<>() ;

            while(head != null) {
                ListNode start = head ;
                for(int i=0; i<k; i++) {
                    if (head == null) {
                        ansTail.next = start ;
                        return ans.next ;
                    }
                    kNodes.add(head) ;
                    head = head.next ;
                }

                while(kNodes.size() != 0) {
                    ListNode pop = kNodes.pop();
                    pop.next = ansTail.next ;
                    ansTail.next = pop ;
                    ansTail = ansTail.next ;
                }


            }

            return ans.next ;
        }
    }
}
