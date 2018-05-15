package LinkedList;

import Type.ListNode;

public class _148_Sort_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public ListNode work(ListNode head) {
		return new Solution().sortList(head) ;
	}
	
	
	public class Solution {
	    public ListNode sortList(ListNode head) {
	    	if (head == null || head.next == null) return head ;
	    	
	    	ListNode head1 = head ;
	    	ListNode head2 = head ;
	    	
	    	// divide
	    	while(head1.next!=null && head1.next.next!=null) {
	    		head1 = head1.next.next ;
	    		head2 = head2.next ;
	    	}
	    	ListNode t = head2 ;
	    	head2 = head2.next ;
	    	t.next = null ;
	    	
	    	// sort two list
	    	ListNode l1 = sortList(head) ;
	    	ListNode l2 = sortList(head2) ;
	    	
	    	// merge
	    	ListNode list = merge(l1, l2) ;
	    	return list ;
	    }
	    
	    public ListNode merge(ListNode l1, ListNode l2) {
	    	ListNode root = new ListNode(-1) ;
	    	ListNode node = root ;
	    	
	    	while(l1!=null || l2!=null) {
	    		int num1 = Integer.MAX_VALUE ;
	    		int num2 = Integer.MAX_VALUE ;
	    		if (l1!=null) num1 = l1.val ;
	    		if (l2!=null) num2 = l2.val ;
	    		if(num1 < num2) {
	    			node.next = l1 ;
	    			node = node.next ;
	    			l1 = l1.next ;
	    		} else {
	    			node.next = l2 ;
	    			node = node.next ;
	    			l2 = l2.next ;
	    		}
	    	}
	    	return root.next ;
	    }
	   
	}
}
