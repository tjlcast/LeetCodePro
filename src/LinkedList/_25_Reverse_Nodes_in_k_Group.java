package LinkedList;

import Type.ListNode;

/**
 * Created by tangjialiang on 17/5/9.
 */
public class _25_Reverse_Nodes_in_k_Group {
    public static void main() {

    }

    public ListNode work(ListNode head, int k) {
        return new Solution().reverseKGroup(head, k) ;
    }

    public class Solution {
        ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) return head ;
            ListNode rootAns = new ListNode(-1) ;
            ListNode tailAns = rootAns ;
            ListNode root = new ListNode(-1) ;
            root.next = head ;

            ListNode addNodes = pollNodes(root, k) ;
            while(addNodes!=null) {
                // add nodes at tailAns position
                while(addNodes!=null) {
                    ListNode tmp = addNodes;
                    addNodes = addNodes.next ;
                    tmp.next = tailAns.next ;
                    tailAns.next = tmp ;
                }
                // move tailAns to end
                while(tailAns.next!=null) {tailAns = tailAns.next ;}
                addNodes = pollNodes(root, k) ;  //for next round, get prefect lists ;
            }

            tailAns.next = root.next ;

            return rootAns.next ;
        }

        ListNode pollNodes(ListNode head, int k) {
            ListNode node = head.next ;
            ListNode ans = new ListNode(-1);
            ListNode tailAns = ans ;

            int count = 0 ;
            while(node!=null && count<k) {

                tailAns.next = node ;
                tailAns = tailAns.next ;
                node = node.next ;
                count++ ;
            }

            head.next = (node!=null)?(node):(null) ;
            tailAns.next = null ;

            if (count != k) {
                head.next = ans.next ;
                return null ;}
            return ans.next ;
        }


    }
}
