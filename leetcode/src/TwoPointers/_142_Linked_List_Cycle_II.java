package TwoPointers;

import Type.ListNode;

public class _142_Linked_List_Cycle_II {

	public static void main(String[] args) {
	}
	
	
	public ListNode work(ListNode head) {
		return new Solution().detectCycle(head) ;
	}
	
	
	public class Solution {
	    public ListNode detectCycle(ListNode head) {
	        ListNode fast = head ;
	        ListNode slow = head ;
	        
	        if (fast==null || fast.next==null) return null ;
	        fast = fast.next.next ;
	        slow = slow.next ;
	        
	        while (fast!=null && fast.next!=null) {
	            
	            if (fast == slow) {
	                // x and y are equal
	                ListNode node1 = head ;
	                ListNode node2 = fast ;
	                
	                while(node1!=node2) {
	                    node1 = node1.next ;
	                    node2 = node2.next ;
	                }
	                return node1 ;
	            }
	            
	            fast = fast.next.next ;
	            slow = slow.next ;
	        }
	        
	        return null ;
	    }
	}

}
