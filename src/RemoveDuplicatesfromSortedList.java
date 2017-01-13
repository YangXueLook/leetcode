public class RemoveDuplicatesfromSortedList {

	public static ListNode deleteDuplicates(ListNode head) {
		
		if (head == null || head.next == null)
			return head;
		
		int currentValue = 0;
		ListNode movingIndex = head.next;
		ListNode newListIndex = head;
		currentValue = head.val;

		while (movingIndex != null) {
			if (movingIndex.next == null) {
				if (movingIndex.val != currentValue) {
					currentValue = movingIndex.val;
					newListIndex.next = movingIndex;
					newListIndex = movingIndex;
					movingIndex = movingIndex.next;
				} else {
					movingIndex = movingIndex.next;
					newListIndex.next = null;
				}
			} else {
				if (movingIndex.val != currentValue) {
					currentValue = movingIndex.val;
					newListIndex.next = movingIndex;
					newListIndex = movingIndex;
					movingIndex = movingIndex.next;
				} else {
					movingIndex = movingIndex.next;
				}
			}

		}

		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(1);
		ListNode l4 = new ListNode(1);
		ListNode l5 = new ListNode(1);
		ListNode l6 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		deleteDuplicates(l1);
		while (l1 != null) {
			System.out.println(l1.val);
			l1 = l1.next;
		}

	}

}
