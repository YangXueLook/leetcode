public class InsertSortList {

	public static ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode currentNode;
		ListNode movingIndex;
		ListNode temp;
		while (head != null) {
			currentNode = head;
			head = head.next;
			currentNode.next = null;
			

			if (dummy.next == null) {
				
				dummy.next = currentNode;
			} else {
				
				movingIndex = dummy;
				while (true) {
					
					if (movingIndex.val <= currentNode.val
							&& movingIndex.next == null) {
						movingIndex.next = currentNode;
						break;
					}
					else if (movingIndex.val <= currentNode.val
							&& movingIndex.next.val <= currentNode.val)
						movingIndex = movingIndex.next;
					else if (movingIndex.val <= currentNode.val
							&& movingIndex.next.val > currentNode.val) {
						temp = movingIndex.next;
						movingIndex.next = currentNode;
						currentNode.next = temp;
						break;
					}

					
				}
			}
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);

		n1.next = n2;

		insertionSortList(n1);

	}

}
