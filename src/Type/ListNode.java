package Type;

public class ListNode {
	public int val;
	public ListNode next;
	
	public int getVal() {
		return val;
	}

	public ListNode getNext() {
		return next;
	}

	public void setVal(Integer val) {
		this.val = val;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public ListNode(Integer x) {
		val = x ;
		next = null ;
	}

	@Override
	public String toString() {
		return val + "" ;
	}

}
