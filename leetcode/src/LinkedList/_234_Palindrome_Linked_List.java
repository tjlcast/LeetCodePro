package LinkedList;

import java.util.Stack;

import Type.ListNode;

public class _234_Palindrome_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean work(ListNode head) {
		return new Solution().isPalindrome(head) ;
	}
	
	public class Solution {
	    public boolean isPalindrome(ListNode head) {
	        Stack<ListNode> s = new Stack<ListNode>() ;
	        
	        ListNode node = head ;
	        while(node != null) {
	            s.add(node) ;
	            node = node.next ;
	        }
	        
	        node = head ;
	        while(!s.empty()) {
	            ListNode cur = s.pop() ;
	            if (cur.val != node.val) {
	                return false ;
	            }
	            node = node.next ;
	        }
	        
	        return true ;
	    }
	}

}
