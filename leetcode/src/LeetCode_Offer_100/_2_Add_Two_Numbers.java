package LeetCode_Offer_100;

import Type.ListNode;
import zz_to_to_offer.page.Page107;

/**
 * Created by tangjialiang on 2018/2/28.
 */
public class _2_Add_Two_Numbers {
    static
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(-1) ;
            ListNode tail = head ;

            int carr = 0 ;
            while(l1!=null || l2!=null) {
                int val1 = (l1==null) ? (0) : (l1.val) ;
                int val2 = (l2==null) ? (0) : (l2.val) ;

                ListNode node = new ListNode((val1 + val2 + carr)%10) ;
                tail.next = node ;
                tail = tail.next ;
                carr = (val1 + val2 + carr) / 10 ;

                if (l1!=null) l1 = l1.next ;
                if (l2!=null) l2 = l2.next ;
            }

            // if carr != 0
            if (carr != 0) {
                ListNode node = new ListNode(carr) ;
                tail.next = node ;
            }

            return head.next ;
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 4} ;
        int[] num2 = {2, 1, 3, 9} ;

        ListNode listNode1 = Page107.buildList(num1);
        ListNode listNode2 = Page107.buildList(num2);

        Solution sol = new Solution() ;
        ListNode listNode = sol.addTwoNumbers(listNode1, listNode2);

        while(listNode != null) {
            System.out.print(listNode.val+" ") ;
            listNode = listNode.next ;
        }
        System.out.println() ;
    }
}
