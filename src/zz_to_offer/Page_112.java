package zz_to_offer;

import Type.ListNode;
import Utils.LinkedListUtils;

import java.util.List;

/**
 * Created by tangjialiang on 2017/8/24.
 */
public class Page_112 {
    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5} ;
        ListNode head = new ListNode(-1) ;
        ListNode list = new LinkedListUtils<ListNode>(ListNode.class).buildLinkedList(nums);
        head.next = list ;

        ListNode work = new Page_112().work(head);
        new LinkedListUtils<ListNode>(ListNode.class).printLinkedList(head);
    }

    public ListNode work(ListNode head) {
        return new MySolution().reverseList(head) ;
    }


    class MySolution {
        public ListNode reverseList(ListNode head) {
            if (head==null || head.next==null) {
                return head;
            }

            return reverse(head);
        }

        private ListNode reverse(ListNode head) {
            ListNode pNewHead = new ListNode(-1) ;

            ListNode list = head.next ;
            while(list != null) {
                ListNode tmp = list ;
                list = list.next ;

                tmp.next = pNewHead ;
                pNewHead.next = tmp ;
            }

            return pNewHead ;
        }
    }
}
