public class RotateList {

	public static ListNode rotateRight(ListNode head, int n) {

		if (head == null)
			return null;

		int length = 0;
		ListNode index = head;

		while (index != null) {
			length++;
			index = index.next;
		}
		if (length == 1)
			return head;

		ListNode tail = head;
		int mod = n % length;
		if (mod == 0)
			return head;

		int offset = length - mod;

		for (int i = 0; i < offset - 1; i++) {
			tail = tail.next;
		}
		ListNode newHead = tail.next;
		tail.next = null;
		index = newHead;

		while (index.next != null) {

			index = index.next;
		}
		index.next = head;

		return newHead;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);

		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;

		ListNode result = rotateRight(l1, 3);

		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}

}
