package zz_to_offer;

import Type.ListNode;
import Utils.LinkedListUtils;

import java.util.LinkedList;

/**
 * Created by tangjialiang on 2017/8/24.
 */
public class Page_114 {
    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然递增排序。
     * @param args
     */
    public static void main(String[] args) {
        int[] numsA = {1, 2, 6, 9, 11} ;
        int[] numsB = {3, 5, 6, 8, 9} ;

        ListNode listA = new LinkedListUtils<ListNode>(ListNode.class).buildLinkedList(numsA);
        ListNode listB = new LinkedListUtils<ListNode>(ListNode.class).buildLinkedList(numsB);

        ListNode headA = new ListNode(-1) ;
        headA.next = listA ;
        ListNode headB = new ListNode(-1) ;
        headB.next = listB ;

        ListNode work = new Page_114().work(headA, headB);
        System.out.println("ans is: ") ;
        new LinkedListUtils<ListNode>(ListNode.class).printLinkedList(work);

    }

    public ListNode work(ListNode headA, ListNode headB) {
        return new MySolution().merge(headA, headB) ;
    }

    class MySolution {
        public ListNode merge(ListNode headA, ListNode headB) {
            ListNode ansHead = new ListNode(-1) ;
            ListNode ansTail = ansHead ;
            ListNode tmpA = headA.next ;
            ListNode tmpB = headB.next ;

            while(tmpA!=null && tmpB!=null) {
                if (tmpA.val < tmpB.val) {
                    ansTail.next = tmpA ;
                    ansTail = ansTail.next ;

                    tmpA = tmpA.next ;
                    ansTail.next = null ;
                } else {
                    ansTail.next = tmpB ;
                    ansTail = ansTail.next ;

                    tmpB = tmpB.next ;
                    ansTail.next = null ;
                }
            }

            if (tmpA != null) {
                ansTail.next = tmpA ;
            }
            if (tmpB != null) {
                ansTail.next = tmpB ;
            }

            return ansHead ;
        }
    }
}
