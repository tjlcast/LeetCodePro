package TwoPointers;

import Type.ListNode;
import Utils.LinkedListUtils;

public class _86_Partition_List {

	public static void main(String[] args) {
		int x = 3 ;
		int[] nums = {1,4,3,2,5,2} ;
		
		LinkedListUtils<ListNode> linkedListUtils = new LinkedListUtils<ListNode>(ListNode.class) ;
		ListNode head = (ListNode) linkedListUtils.buildLinkedList(nums) ;
		
		ListNode work = new _86_Partition_List().work(head, x) ;
		System.out.println("work: ") ;
		linkedListUtils.printLinkedList(work);
	}
	
	
	public ListNode work(ListNode head, int x) {
		return new Solution().partition(head, x) ;
	}
	

	public class Solution {
	    public ListNode partition(ListNode head, int x) {
	        ListNode node = head ;
	        ListNode lessNodeHead = new ListNode(-1) ;
	        ListNode lessNode = lessNodeHead ;
	        ListNode moreAndEqualNodeHead = new ListNode(-1) ;
	        ListNode moreAndEqualNode = moreAndEqualNodeHead ;
	        
	        while(node != null) {
	            ListNode tmp = node ;
	            node = node.next ;
	            if (tmp.val < x) {
	                lessNode.next = tmp ;
	                lessNode = lessNode.next ;
	            } else {
	                moreAndEqualNode.next = tmp ;
	                moreAndEqualNode = moreAndEqualNode.next ;
	            }
	            
	        }
	        
	        lessNode.next = moreAndEqualNodeHead.next ;
	        moreAndEqualNode.next = null ;
	        return lessNodeHead.next ;
	    }
	}

}
