package LinkedList;

import Type.ListNode;

public class _19_Remove_Nth_Node_From_End_of_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode work(ListNode head, int n) {
		return new Solution().removeNthFromEnd(head, n) ;
	}
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public class Solution {
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	        ListNode root = new ListNode(-1) ;
	        root.next = head ;
	        
	        int totalNum = 0 ;
	        ListNode node = root ;
	        while(node.next != null) {
	            totalNum++ ;
	            node = node.next ;
	        }
	        
	        int removePos = totalNum - (n - 1) ;
	        int pos = 0 ;
	        node = root ;
	        while(node.next != null) {
	            pos++ ;
	            if (pos == removePos) {
	                node.next = node.next.next ;
	                continue ;
	            }
	            node = node.next ;
	        }
	        
	        return root.next ;
	    }
	}

}
