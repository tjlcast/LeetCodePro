package LinkedList;

import Type.ListNode;

public class _206_Reverse_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void work(ListNode head){
		new Solution().reverseList(head) ;
	}
	
	public class Solution {
	    public ListNode reverseList(ListNode head) {
	        ListNode root = new ListNode(-1) ;
	        
	        while(head != null) {
	        	ListNode curNode = head ;
	        	head = head.next ;
	        	
	        	curNode.next = root.next ;
	        	root.next = curNode ;
	        }
	        return root.next ;
	    }
	}

}
