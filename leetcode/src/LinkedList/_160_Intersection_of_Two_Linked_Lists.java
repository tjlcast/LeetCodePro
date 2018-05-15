package LinkedList;

import Type.ListNode;

public class _160_Intersection_of_Two_Linked_Lists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode work(ListNode headA, ListNode headB) {
		return new Solution().getIntersectionNode(headA, headB) ;
	}
	
	public class Solution {
	    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        if (headA==null || headB==null) return null ;
	        ListNode node = null ;
	        
	        int lenA = 0 ;
	        int lenB = 0 ;
	        
	        node = headA ;
	        while(node!=null) {node = node.next; lenA++;}
	        node = headB ;
	        while(node!=null) {node = node.next; lenB++;}
	        
	        if (lenB > lenA) {
	            ListNode temp = headA ;
	            headA = headB ;
	            headB = temp ;
	            int tLen = lenB ;
	            lenB = lenA ;
	            lenA = tLen ;
	        }
	        
	        ListNode nodeA = headA ;
	        ListNode nodeB = headB ;
	        int diff = lenA - lenB ;
	       
	        while(diff > 0) {
	            System.out.println(nodeA.val) ;
	            nodeA = nodeA.next ;
	            diff-- ;
	        }
	        
	        if (nodeB==null || nodeA==null) return null ;
	        while(nodeA.val != nodeB.val) {
	            nodeA = nodeA.next ;
	            nodeB = nodeB.next ;
	            if (nodeB==null || nodeA==null) return null ;
	        }
	        
	        if (nodeB!=null && nodeA!=null && nodeA.val==nodeB.val) return nodeA ;
	        return null ;
	    }
	}
}
