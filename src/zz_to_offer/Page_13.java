package zz_to_offer;

import Type.ListNode;
import Utils.LinkedListUtils;

/**
 * Created by tangjialiang on 2017/8/16.
 */
public class Page_13 {

    /**
     * 找到链表的倒数第K个元素。
     * */

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4} ;
        int k = 3 ;
        ListNode listNode = new LinkedListUtils<ListNode>(ListNode.class).buildLinkedList(arr);
        ListNode root = new ListNode(-1) ;
        root.next = listNode ;

        ListNode work = new Page_13().work(root, k);
        System.out.println((work!=null) ? "work value is " + (work.val) : "work is null") ;
    }

    public ListNode work(ListNode root, int k) {
        return new ProblemPage13().findKthToTail(root, k) ;
    }

    class ProblemPage13 {

        ListNode findKthToTail(ListNode root, int k) {
            if (root == null || root.next==null || k<=0) return null ;
            ListNode aS = root.next ;
            ListNode bS = root.next ;

            // first move a pointer k steps
            for(int i=1; i<k; i++) {
                aS = aS.next ;
                if (aS == null) return bS ;
            }

            // second move a and b pointer step by step (until a pointer to be null)
            while(aS.next != null) {
                aS = aS.next ;
                bS = bS.next ;
            }
            return bS ;
        }
    }
}
