public class SortList {

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;
		ListNode fast = dummy;
		ListNode slow = dummy;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode secondHalf = slow.next;
		slow.next = null;

		ListNode r1 = sortList(head);
		ListNode r2 = sortList(secondHalf);


		ListNode dummyResult = new ListNode(Integer.MIN_VALUE);

		ListNode movingIndexR = dummyResult;

		while (r1 != null && r2 != null) {
			if (r1.val <= r2.val) {
				movingIndexR.next = r1;
				r1 = r1.next;
				movingIndexR = movingIndexR.next;
			} else {
				movingIndexR.next = r2;
				r2 = r2.next;
				movingIndexR = movingIndexR.next;
			}
		}
		if (r1 == null) {
			movingIndexR.next = r2;
		} else {
			movingIndexR.next = r1;
		}

		return dummyResult.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
