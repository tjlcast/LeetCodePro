package zz_to_to_offer.page;

import Type.ListNode;

/**
 * Created by tangjialiang on 2018/2/27.
 */
public class Page107 {

    /*
    * 输入一个链表，输出该链表中倒数第k个节点。
    **/

    public static ListNode outputKNode(ListNode head, int k) {
        if (head == null) return null ;

        ListNode fast = head ;
        ListNode slow = head ;
        int step = k ;
        while(fast != null && step > 1) {
            fast = fast.next ;
            step-- ;
        }
        if (fast == null) return null ;

        while(fast.next != null) {
            fast = fast.next ;
            slow = slow.next ;
        }
        return slow ;
    }

    public static ListNode buildList(int[] nums) {
        ListNode root = new ListNode(-1) ;
        ListNode node = root ;

        for(Integer num : nums) {
            ListNode tmpNode = new ListNode(num) ;
            node.next = tmpNode ;
            node = tmpNode ;
        }
        return root.next ;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6} ;
        int k = 9 ;

        ListNode head = buildList(nums);
        ListNode node = outputKNode(head, k);

        System.out.println((node==null) ? ("null") : (node.val)) ;
    }
}
