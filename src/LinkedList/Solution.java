package LinkedList;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
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
			if (num1 + num2 >= 10) {
				car = (num1 + num2) / 10;
			}
		}
		return root.next;
	}
}
