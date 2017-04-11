package LinkedList;

import Type.ListNode;

public class _237_Delete_Node_in_a_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void work(ListNode node) {
		new Solution().deleteNode(node);
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
	    public void deleteNode(ListNode node) {
	        ListNode curNode = node ;
	        ListNode nextNode = node.next ;
	        
	        int temp = curNode.val ;
	        curNode.val = nextNode.val ;
	        nextNode.val = temp ;
	        
	        curNode.next = nextNode.next ;
	    }
	}

}
