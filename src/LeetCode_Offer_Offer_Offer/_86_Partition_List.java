package LeetCode_Offer_Offer_Offer;

import Type.ListNode;
import Utils.LinkedListUtils;

/**
 * Created by tangjialiang on 2017/9/19.
 *
 */
public class _86_Partition_List {
    /**
     * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

     You should preserve the original relative order of the nodes in each of the two partitions.

     For example,
     Given 1->4->3->2->5->2 and x = 3,
     return 1->2->2->4->3->5.
     */

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 5, 2} ;
        int x = 3 ;

        ListNode nodeHead = new LinkedListUtils<ListNode>(ListNode.class).buildLinkedList(arr);

        _86_Partition_List partition_list = new _86_Partition_List();
        ListNode work = partition_list.work(nodeHead, x);

        System.out.println("work is: ") ;
        new LinkedListUtils<ListNode>(ListNode.class).printLinkedList(work);
    }

    public ListNode work(ListNode head, int x) {
        Solution solution = new Solution();
        ListNode partition = solution.partition(head, x);
        return partition ;
    }

    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode smallRoot = new ListNode(-1) ;
            ListNode smallTail = smallRoot ;
            ListNode bigRoot = new ListNode(-1) ;
            ListNode bigTail = bigRoot ;

            while(head != null) {
                ListNode workNode = head ;
                head = head.next ;

                if (workNode.val < x) {
                    smallTail.next = workNode ;
                    smallTail = smallTail.next ;
                    smallTail.next = null ;
                } else {
                    bigTail.next = workNode ;
                    bigTail = bigTail.next ;
                    bigTail.next = null ;
                }
            }

            smallTail.next = bigRoot.next ;
            return smallRoot.next ;
        }
    }
}
