package LinkedList;

import Type.ListNode;

/**
 * Created by tangjialiang on 17/5/9.
 */
public class _24_Swap_Nodes_in_Pairs {
    public static void main(String[] args) {

    }

    public ListNode work(ListNode head) {
        return new Solution().swapPairs(head) ;
    }

    public class Solution {
        ListNode swapPairs(ListNode head) {
            if (head == null) return head ;

            ListNode root = new ListNode(-1) ;
            ListNode tail = root ;
            root.next = head ;

            while(tail.next!=null && tail.next.next!=null) {
                ListNode secondLine = tail.next.next.next ;

                tail.next.next.next = tail.next ;
                tail.next = tail.next.next ;
                tail.next.next.next = secondLine ;

                tail = tail.next.next ;
            }

            return root.next ;
        }
    }
}
