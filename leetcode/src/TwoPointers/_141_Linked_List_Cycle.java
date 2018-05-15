package TwoPointers;

import Type.ListNode;

public class _141_Linked_List_Cycle {

	public static void main(String[] args) {
	}
	
	public boolean work(ListNode head) {
		return new Solution().hasCycle(head) ;
	}
	
	public class Solution {
	    public boolean hasCycle(ListNode head) {
	    	if (head==null || head.next==null || head.next.next==null) return false ;
	    	
	    	ListNode fast = head.next.next ;
	    	ListNode slow = head.next ;
	    	
	    	while(fast.next!=null && fast.next.next!=null) {
	    		if (fast == slow) return true ;
	    		
	    		fast = fast.next.next ;
	    		slow = slow.next ;
	    	}
	    	
	        return false ;
	    }
	}

}
