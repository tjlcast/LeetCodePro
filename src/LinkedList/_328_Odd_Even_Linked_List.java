package LinkedList;

import Type.ListNode;

public class _328_Odd_Even_Linked_List {

	public static void main(String[] args) {
		
	}
	
	public ListNode work(ListNode head) {
		return new Solution().oddEvenList(head) ;
	}
	
	public class Solution {
	    public ListNode oddEvenList(ListNode head) {
	        ListNode oddHead = new ListNode(-1) ;
	        ListNode oddNode = oddHead ;
	        ListNode evenHead = new ListNode(-1) ;
	        ListNode evenNode = evenHead ;
	        
	        int step = 1 ;
	        ListNode curNode = head ;
	        while(curNode != null) {
	            ListNode tempNode = curNode ;
	            curNode = curNode.next ;
	            
	            if (step%2 == 0) {
	                evenNode.next = tempNode ;
	                evenNode = tempNode ;
	            } else {
	                oddNode.next = tempNode ;
	                oddNode = tempNode ;
	            }
	            step++ ;
	        }
	        
	        oddNode.next = evenHead.next ;
	        evenNode.next = null ;
	        
	        return oddHead.next ;
	    }
	}
}
