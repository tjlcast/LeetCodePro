package zz_to_offer;

import Type.ListNode;

import java.util.Stack;

/**
 * Created by tangjialiang on 2017/8/29.
 */
public class Page_193 {
    /**
     * 输入两个链表，找出它们的第一个公共节点
     */

    public static void main(String[] args) {

    }

    ListNode work(ListNode pHead1, ListNode pHead2) {
        return null ;
    }

    class MySolution {
        /**
         * tips: 通过两个链表的长度，把两个链表变形为相同长度的链表。
         */
        ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            // find distance of two lists. => len
            int len = 0 ;
            ListNode head1 = pHead1 ;
            ListNode head2 = pHead2 ;
            int step1 = 0 ;
            int step2 = 0 ;
            while(head1!=null) {
                step1++ ;
                head1 = head1.next ;
            }
            while (head2!=null) {
                step2++ ;
                head2 = pHead2.next ;
            }
            len = (step1 > step2) ? (step1 - step2) : (step2 - step1) ;

            // change longer list to be same length of another list. => same length list
            head1 = pHead1 ;
            head2 = pHead2 ;
            if (step1 > step2) {
                while(len>0) {
                    head1 = head1.next ;
                    len-- ;
                }
            } else {
                while(len>0) {
                    head2 = head2.next ;
                    len-- ;
                }
            }

            // node by node judge nodes are the same. => the node
            ListNode ans = null ;
            while(head1!=null && head2!=null) {
                if (head1 == head2) {
                    ans = head1 ;
                    break ;
                }
                head1 = head1.next ;
                head2 = head2.next ;
            }

            return ans ;
        }
    }

    class MySolution1 {
        /**
         * tips: 使用两个栈分别存储两个链表，从尾到头进行比较
         */
        private Stack<ListNode> stack1 = new Stack<>() ;
        private Stack<ListNode> stack2 = new Stack<>() ;

        ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            ListNode head1 = pHead1 ;
            ListNode head2 = pHead2 ;

            while(head1 != null) {
                stack1.add(head1) ;
                head1 = head1.next ;
            }
            while(head2 != null) {
                stack2.add(head2) ;
                head2 = head2.next ;
            }

            ListNode ans = null ;
            while(stack1.size()!=0 && stack2.size()!=0) {
                ListNode pop1 = stack1.pop();
                ListNode pop2 = stack2.pop();

                if (pop1 == pop2) {
                    ans = pop1 ;
                    break ;
                }
            }

            return ans ;
        }
    }
}
