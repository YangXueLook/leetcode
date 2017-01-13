public class SwapNodesInPairs {
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode current = dummy;
		ListNode temp1;

		ListNode temp2;

		while (current != null && current.next != null
				&& current.next.next != null) {
			temp1 = current.next.next.next;
			temp2 = current.next;
			
			current.next = current.next.next;
			
			current.next.next = temp2;
			
			
			temp2.next = temp1;
			
			current = current.next.next;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
//		l5.next = l6;

		ListNode result = swapPairs(l1);

		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}

}
