package z_Company.book._02;

import Type.ListNode;
import static java.lang.Math.max ;
import static java.lang.Math.min ;

/**
 * Created by tangjialiang on 2018/4/3.
 */
public class Page34 {

    private static void work(ListNode root1, ListNode root2) {
        int len1 = getListLen(root1) ;
        int len2 = getListLen(root2) ;
        int diff = max(len1, len2) - min(len1, len2) ;

        if (len1 > len2) {
            root1 = moveToN(root1, diff) ;
        } else if (len1 < len2) {
            root2 = moveToN(root2, diff) ;
        }

        while(root1!=root2) {
            root1 = root1.next ;
            root2 = root2.next ;
        }

        while(root1!=null) {
            System.out.print(root1.val + " ");
            root1 = root1.next ;
        }
        System.out.println() ;
    }

    private static int getListLen(ListNode root) {
        int len = 0 ;
        while(root != null) {
            len++ ;
            root = root.next ;
        }
        return len ;
    }

    private static ListNode moveToN(ListNode root, int skip) {
        while(root != null && skip!=0) {
            skip-- ;
            root = root.next ;
        }
        return root ;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4} ;
        int[] arr2 = {5, 6, 7} ;
        int[] arr3 = {8, 9, 10} ;

        ListNode root1 = buildList(arr1) ;
        ListNode root2 = buildList(arr2) ;
        ListNode root3 = buildList(arr3) ;
        linkList(root1, root2, root3) ;

        work(root1, root2);
    }

    private static void linkList(ListNode root1, ListNode root2, ListNode root3) {
        while(root1.next != null) root1 = root1.next ;
        while(root2.next != null) root2 = root2.next ;
        root1.next = root3 ;
        root2.next = root3 ;

        return ;
    }

    private static ListNode buildList(int[] arr1) {
        ListNode head = new ListNode(-1) ;
        ListNode tail = head ;
        for (Integer i :
                arr1) {
            tail.next = new ListNode(i) ;
            tail = tail.next ;
        }
        return head.next ;
    }
}
