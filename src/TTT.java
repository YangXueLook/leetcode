public class TTT {

	public ListNode getSecondHalfHead(ListNode head) {
		if (head == null)
			return null;

		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;

		}

		ListNode result = slow.next;
		slow.next = null;

		return result;
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode p = head;
		ListNode q = head.next;
		ListNode r;
		p.next = null;

		while (q != null) {
			r = q.next;
			q.next = p;
			p = q;
			q = r;
		}

		return p;

	}

	public void mergeTwoListsOneByOne(ListNode firstHead, ListNode secondHead) {
		if (firstHead != null && secondHead != null) {
			ListNode p = firstHead;
			ListNode q = secondHead;
			ListNode temp1, temp2;
			while (p.next != null) {
				temp1 = p.next;
				temp2 = q.next;
				p.next = q;
				p.next.next = temp1;
				p = p.next.next;
				q = temp2;
			}
			if (q != null)
				p.next = q;

		}

	}

	public void reorderList(ListNode head) {

		if ( head != null&& head.next != null) {
			ListNode secondHead = getSecondHalfHead(head);
			secondHead = reverseList(secondHead);
			mergeTwoListsOneByOne(head, secondHead);
		}

	}

	public static void main(String[] args) {
		TTT t = new TTT();

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;

		t.reorderList(n1);

		ListNode head = n1;
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
