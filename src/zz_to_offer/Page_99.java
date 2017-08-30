package zz_to_offer;

import Type.ListNode;

/**
 * Created by tangjialiang on 2017/8/24.
 */
public class Page_99 {
    /**
     * 给定单向链表的头指针和一个节点指针，定义一个函数在O（1）时间删除该节点
     */

    public static void main(String[] args) {

    }

    class MySolution {
        /**
         * 因为只输入需要删除节点的指针，故使用删除节点的下一个节点覆盖当前节点（此时链表中有两个内容相同的节点），再删除下一个重复节点。
         */
        // the linkedList has the head node.
        public void deleteNode(ListNode head, ListNode pToBeDeleted) {
            if (head.next == null || pToBeDeleted==null) return;
            rewriteAndDelete(head, pToBeDeleted);
        }

        private void rewriteAndDelete(ListNode head, ListNode pToBeDeleted) {
            // is tail node
            if (pToBeDeleted.next == null) {
                ListNode tp = head ;
                while(tp.next != null) {
                    if (tp.next == pToBeDeleted) {
                        tp.next = pToBeDeleted.next;
                        return ;
                    }
                    tp = tp.next;
                }
            }

            // not be tail node
            pToBeDeleted.val = pToBeDeleted.next.val ;
            pToBeDeleted.next = pToBeDeleted.next.next ;
            return ;
        }
    }
}
