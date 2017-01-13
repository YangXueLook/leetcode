public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode currentIndex1 = l1;
		ListNode currentIndex2 = l2;
		ListNode index;
		if (l1.val < l2.val) {
			index = l1;
			currentIndex1 = currentIndex1.next;
		} else {
			index = l2;
			currentIndex2 = currentIndex2.next;
		}

		while (currentIndex1 != null && currentIndex2 != null) {
			if (currentIndex1.val < currentIndex2.val) {
				index.next = currentIndex1;
				currentIndex1 = currentIndex1.next;
				index = index.next;
			} else {
				index.next = currentIndex2;
				currentIndex2 = currentIndex2.next;
				index = index.next;
			}
		}
		if (currentIndex1 == null) {
			index.next = currentIndex2;
		} else {
			index.next = currentIndex1;
		}

		if (l1.val < l2.val) {
			return l1;
		} else {
			return l2;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
