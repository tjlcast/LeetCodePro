package z_Company.book._02;

import Type.ListNode;
import java.util.* ;

/**
 * Created by tangjialiang on 2018/4/3.
 */
public class Page43 {

    public static class Solution {

        ListNode work(ListNode head, int m) {
            if (head == null) return null ;
            ListNode ptr = head ;
            while(ptr.next!=head) {
                ptr = ptr.next ;
            }

            while(!isLastNode(ptr.next)) {
                for (int i = 0; i < m-1; i++) {
                    ptr = ptr.next ;
                }
                // remove ptr.next
                System.out.println(ptr.next.val) ;
                ListNode nextNode = ptr.next.next ;
                ptr.next = nextNode ;
            }
            return ptr ;
        }

        private boolean isLastNode(ListNode node) {
            if (node!=null && node.next==node) return true ;
            return false ;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int m = sc.nextInt() ;

        ListNode cyc = buildCircyle(n) ;
        Solution sol = new Solution() ;
        ListNode work = sol.work(cyc, m);

        System.out.println((cyc==null)?("null"):(work));
    }

    private static ListNode buildCircyle(int n) {
        ListNode head = new ListNode(-1) ;
        ListNode tail = head ;

        for (int i = 0; i < n; i++) {
            ListNode node = new ListNode(i) ;
            tail.next = node ;
            tail = tail.next ;
        }

        tail.next = head.next ;
        return head.next ;
    }
}
