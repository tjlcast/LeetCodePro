package LeetCode_Offer_Offer_Offer;

import Type.ListNode;
import Utils.LinkedListUtils;

/**
 * Created by tangjialiang on 2017/8/31.
 */
public class _2_Add_Two_Numbers {
    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

     You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
     */

    public static void main(String[] args) {
        int[] num1 = {2, 4, 3} ;
        int[] num2 = {5, 6, 4} ;

        ListNode l1 = new LinkedListUtils<ListNode>(ListNode.class).buildLinkedList(num1);
        ListNode l2 = new LinkedListUtils<ListNode>(ListNode.class).buildLinkedList(num2);

        ListNode work = new _2_Add_Two_Numbers().work(l1, l2);
        System.out.println("answer") ;
        new LinkedListUtils<ListNode>(ListNode.class).printLinkedList(work);
    }

    public ListNode work(ListNode l1, ListNode l2) {
        return new Solution().addTwoNumbers(l1, l2) ;
    }

    class Solution {
        /**
         * 根据加法法则，每个nodel通过node1.val + node2.val + carr得到。
         * 注意： 在计算的最后，若carr不为零，应该额外添加一个节点。
         */

        ListNode headNode = new ListNode(-1) ;
        ListNode tail = headNode ;

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carr = 0 ;
            ListNode node1 = l1 ;
            ListNode node2 = l2 ;

            while(node1!=null || node2!=null) {
                int val1 = (node1==null) ? (0) : (node1.val) ;
                int val2 = (node2==null) ? (0) : (node2.val) ;

                int count = (val1 + val2 + carr) ;
                int val = count % 10 ;
                carr = count / 10 ;

                ListNode node = new ListNode(val) ;
                tail.next = node ;
                tail = tail.next ;

                if (node1 != null) node1 = node1.next ;
                if (node2 != null) node2 = node2.next ;
            }

            if (carr != 0) {
                ListNode node = new ListNode(carr) ;
                tail.next = node ;
                tail = tail.next ;
            }

            return headNode.next ;
        }
    }
}
