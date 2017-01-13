public class PartitionList {

	public static ListNode partition(ListNode head, int x) {

		if (head == null || head.next == null)
			return head;

		ListNode lowerDummy = new ListNode(0);
		ListNode higherDummy = new ListNode(0);

		ListNode lowerMoving = lowerDummy;
		ListNode higherMoving = higherDummy;
		ListNode moving = head;

		while (moving != null) {
			if (moving.val < x) {
				lowerMoving.next = moving;
				lowerMoving = lowerMoving.next;
			} else {
				higherMoving.next = moving;
				higherMoving = higherMoving.next;
			}
			moving = moving.next;
		}
		lowerMoving.next = higherDummy.next;
		higherMoving.next = null;

		return lowerDummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(2);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;

		ListNode l = partition(l1, 3);

		while (l != null) {
			System.out.println(l.val);
			l = l.next;
		}

	}

}
