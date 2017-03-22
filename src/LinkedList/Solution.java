package LinkedList;

import Type.ListNode;
import Utils.LinkedListUtils;

public class Solution {

	public static void main(String[] args) {
		
		LinkedListUtils<ListNode> utils = new LinkedListUtils<>(ListNode.class);
		int[] d1 = { 2, 4, 3 };
		int[] d2 = { 5, 6, 4 };
		ListNode l1 = utils.buildLinkedList(d1);
		ListNode l2 = utils.buildLinkedList(d2);

		ListNode ans = new Solution().addTwoNumbers(l1, l2);
		utils.printLinkedList(ans);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode root = new ListNode(-1);
		ListNode lastNode = root;
		int car = 0;
		while (l1 != null || l2 != null || car != 0) {
			int num1 = 0, num2 = 0, sum = 0;
			if (l1 != null) {
				num1 = l1.val;
			}
			if (l2 != null) {
				num2 = l2.val;
			}
			sum = (num1 + num2 + car) % 10;
			ListNode tempNode = new ListNode(sum);
			lastNode.next = tempNode;
			lastNode = tempNode;

			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
			car = (num1 + num2 + car) / 10;
		}
		return root.next;
	}
}
