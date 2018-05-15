package LinkedList;

import Type.ListNode;

public class _147_Insertion_Sort_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode work(ListNode head) {
		return new Solution().insertionSortList(head) ;
	}

	public class Solution {
		public ListNode insertionSortList(ListNode head) {
			ListNode root = new ListNode(-1);

			while (head != null) {
				ListNode node = head;
				System.out.println(node.val);
				head = head.next;

				insertNode(root, node);
			}

			return root.next;
		}

		public void insertNode(ListNode root, ListNode node) {
			while (root.next != null) {
				if (root.next.val > node.val) {
					node.next = root.next;
					root.next = node;
					return;
				}
				root = root.next;
			}

			node.next = root.next;
			root.next = node;
		}
	}

}
