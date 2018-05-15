package LinkedList;

import Type.ListNode;

public class _203_Remove_Linked_List_Elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode work(ListNode head, int val) {
		return new Solution().removeElements(head, val) ;
	}
	
	public class Solution {
	    public ListNode removeElements(ListNode head, int val) {
	        ListNode root = new ListNode(-1) ;
	        ListNode node = root ;
	        root.next = head ;
	        
	        while(node.next != null) {
	            if (node.next.val == val) {
	                node.next = node.next.next ;
	                continue ;
	            }
	            node = node.next ;
	        }
	        
	        return root.next ;
	    }
	}
}
