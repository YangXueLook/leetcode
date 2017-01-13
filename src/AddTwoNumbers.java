public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result;

		boolean l1IsLongerOrEuqal;
		ListNode i1 = l1;
		ListNode i2 = l2;
		ListNode marker;

		while (i1 != null && i2 != null) {
			i1 = i1.next;
			i2 = i2.next;
		}
		if (i2 == null)
			l1IsLongerOrEuqal = true;
		else
			l1IsLongerOrEuqal = false;

		result = l1IsLongerOrEuqal ? l1 : l2;
		marker = result;

		boolean carry = false;
		while (l1 != null && l2 != null) {
			int temp = l1.val + l2.val;
			if (carry) {
				temp++;
			}

			if (temp > 9) {
				if (l1IsLongerOrEuqal)
					l1.val = temp % 10;
				else
					l2.val = temp % 10;
				carry = true;
			} else {
				if (l1IsLongerOrEuqal)
					l1.val = temp;
				else
					l2.val = temp;
				carry = false;
			}

			if (l1IsLongerOrEuqal)
				marker = l1;
			else
				marker = l2;

			l1 = l1.next;
			l2 = l2.next;
		}
		ListNode tailIndex = l1IsLongerOrEuqal ? l1 : l2;
		if (carry && tailIndex == null) {

			ListNode oneMoretTailNode = new ListNode(1);
			marker.next = oneMoretTailNode;
		}

		ListNode beforeTailIndex = tailIndex;

		if (tailIndex != null) {
			while (tailIndex != null && carry) {
				int temp = tailIndex.val + 1;
				if (temp > 9) {
					tailIndex.val = temp % 10;
					carry = true;
				} else {
					tailIndex.val = temp;
					carry = false;
				}
				beforeTailIndex = tailIndex;
				tailIndex = tailIndex.next;
			}
			if (carry && tailIndex == null) {

				ListNode oneMoretTailNode = new ListNode(1);
				beforeTailIndex.next = oneMoretTailNode;
			}
		}

		return result;
	}

	public static void main(String[] args) {

		ListNode n11 = new ListNode(5);
//		ListNode n12 = new ListNode(4);
//		ListNode n13 = new ListNode(5);
//		n11.next = n12;
//		n12.next = n13;

		ListNode n21 = new ListNode(5);
//		ListNode n22 = new ListNode(6);
//		ListNode n23 = new ListNode(4);
//		ListNode n24 = new ListNode(9);
//		n21.next = n22;
//		n22.next = n23;
//		n23.next = n24;

		ListNode result = addTwoNumbers(n11, n21);

		while (result != null) {
			System.out.println(result.val);
			result = result.next;
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