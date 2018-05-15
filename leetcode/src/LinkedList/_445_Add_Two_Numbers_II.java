package LinkedList;

import java.util.Stack;

import Type.ListNode;

public class _445_Add_Two_Numbers_II {

	public static void main(String[] args) {
		
	}
	
	public ListNode work(ListNode l1, ListNode l2) {
		return  new Solution().addTwoNumbers(l1, l2) ;
	}
	
	public class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	ListNode root = null ;
	    	Stack<ListNode> queueL1 = new Stack<ListNode>() ;
	    	Stack<ListNode> queueL2 = new Stack<ListNode>() ;
	    	
	    	while(l1!=null) {
	    		queueL1.add(l1) ;
	    		l1 = l1.next ;
	    	}
	    	while(l2!=null) {
	    		queueL2.add(l2) ;
	    		l2 = l2.next ;
	    	}
	    	
	    	int carry = 0 ;
	    	while(queueL1.size()!=0 || queueL2.size()!=0) {
	    	    int val1 = 0 , val2 = 0 ;
	    		try {
	    		    ListNode node1 = queueL1.pop() ;
	    		    if (node1!=null) val1 = node1.val ;
	    		} catch(Exception e) {
	    		    
	    		}
	    		try {
	    		    ListNode node2 = queueL2.pop() ;
	    		    if (node2!=null) val2 = node2.val ;
	    		} catch(Exception e) {
	    		    
	    		}
	    		
	    		ListNode tempNode = new ListNode((val1 + val2 + carry)%10) ;
	    		carry = (val1 + val2 + carry) / 10 ;
	    		tempNode.next = root ;
	    		root = tempNode ;
	    	}
	    	
	    	if (carry != 0) {
	    	    ListNode tempNode = new ListNode((carry)%10) ;
	    		tempNode.next = root ;
	    		root = tempNode ;
	    	}
	    	
	        return root ;
	    }
	    
	}
} 
