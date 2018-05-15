package z_Company.book._02;

import Type.ListNode;

/**
 * Created by tangjialiang on 2018/4/3.
 *
 */
public class Page40 {
    public static ListNode reverse(ListNode root) {
        ListNode head = new ListNode(-1) ;

        while(root != null) {
            ListNode node = root ;
            root = root.next ;

            node.next = head.next ;
            head.next = node ;
        }
        return head.next ;
    }

    public static ListNode buildList(int[] arr) {
        ListNode head = new ListNode(-1) ;
        ListNode tail = head ;

        for (Integer i :
                arr) {
            ListNode node = new ListNode(i) ;
            tail.next = node ;
            tail = tail.next ;
        }
        return head.next ;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5} ;

        ListNode listNode = buildList(arr);
        ListNode reverse = reverse(listNode);
        printList(reverse) ;
    }

    private static void printList(ListNode reverse) {
        while(reverse != null) {
            System.out.print(reverse.val + " ") ;
            reverse = reverse.next ;
        }
        System.out.println(); ;
        return ;
    }
}
