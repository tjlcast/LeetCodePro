package LeetCode_Offer_Offer_Offer;

import Type.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/12/10.
 */
public class _143_Reorder_List {
    /**
     * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

     You must do this in-place without altering the nodes' values.

     For example,
     Given {1,2,3,4}, reorder it to {1,4,2,3}.
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reorderList(null);
    }

    static class Solution {
        public void reorderList(ListNode head) {
            ListNode ansRoot = new ListNode(-1) ;
            ListNode ansTail = ansRoot ;

            LinkedList<ListNode> eles = new LinkedList<>() ;

            ListNode node = head ;
            while(node != null) {
                eles.add(node) ;
                node = node.next ;
            }

            while(!eles.isEmpty()) {
                ListNode first = eles.removeFirst();
                ListNode last = (eles.isEmpty()) ? (null) : (eles.removeLast()) ;

                if(ansTail!=null)ansTail.next = first ;
                if(ansTail!=null)ansTail = ansTail.next ;
                if(ansTail!=null)ansTail.next = null ;

                if(ansTail!=null)ansTail.next = last ;
                if(ansTail!=null)ansTail = ansTail.next ;
                if(ansTail!=null)ansTail.next = null ;
            }
        }
    }
}
