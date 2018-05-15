package LeetCode_Offer_Offer_Offer;

import Type.ListNode;

/**
 * Created by tangjialiang on 2018/1/29.
 */
public class _237_Delete_Node_in_a_Linked_List {

    public static void main(String[] args) {
        ListNode node = null ;

        Solution sol = new Solution() ;
        sol.deleteNode(node);

        System.out.println("The work is: ") ;
    }

    static class Solution {
        public void deleteNode(ListNode node) {
            for(; node.next.next!=null; node=node.next) {
                if (node.next != null) {
                    node.val = node.next.val ;
                }
            }
            node.val = node.next.val ;
            node.next = null ;
            return ;
        }
    }
}
