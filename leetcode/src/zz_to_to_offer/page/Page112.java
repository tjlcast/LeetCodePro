package zz_to_to_offer.page;

import Type.ListNode;

/**
 * Created by tangjialiang on 2018/2/27.
 */
public class Page112 {

    public static ListNode reverse(ListNode head) {
        ListNode root = new ListNode(-1) ;
        ListNode node = head ;

        while(node != null) {
            ListNode tmpNode = node ;
            node = node.next ;

            tmpNode.next = root.next ;
            root.next = tmpNode ;
        }

        return root.next ;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6} ;
        ListNode head = Page107.buildList(nums);

        ListNode reverse = Page112.reverse(head);

        while(reverse != null) {
            System.out.println(reverse.val) ;
            reverse = reverse.next ;
        }
    }
}
