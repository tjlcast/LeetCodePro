package LeetCode_Offer_Offer_Offer;

import Type.ListNode;
import Utils.LinkedListUtils;

/**
 * Created by tangjialiang on 2017/9/2.
 */
public class _21_Merge_Two_Sorted_Lists {
    /**
     * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
     */

    public static void main(String[] args) {
        int[] nodes1 = {1, 3, 5, 8, 10} ;
        int[] nodes2 = {2, 4, 6} ;
        ListNode listNode1 = new LinkedListUtils<ListNode>(ListNode.class).buildLinkedList(nodes1);
        ListNode listNode2 = new LinkedListUtils<ListNode>(ListNode.class).buildLinkedList(nodes2);

        ListNode work = new _21_Merge_Two_Sorted_Lists().work(listNode1, listNode2);

        System.out.println("work is: ") ;
        new LinkedListUtils<ListNode>(ListNode.class).printLinkedList(work);
    }

    public ListNode work(ListNode l1, ListNode l2) {
        Solution solution = new Solution();
        ListNode listNode = solution.mergeTwoLists(l1, l2);
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
        ListNode root = new ListNode(-1) ;
        ListNode tail = root ;

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            while(l1!=null || l2!=null) {
                int val1 = (l1==null) ? (Integer.MAX_VALUE) : (l1.val) ;
                int val2 = (l2==null) ? (Integer.MAX_VALUE) : (l2.val) ;

                ListNode tmp = null ;
                if (val1 < val2){
                    tmp = l1 ;
                    l1 = l1.next ;
                } else {
                    tmp = l2 ;
                    l2 = l2.next ;
                }

                tmp.next = tail.next ;
                tail.next = tmp ;
                tail = tail.next ;
            }

            return root.next ;
        }
    }
}
