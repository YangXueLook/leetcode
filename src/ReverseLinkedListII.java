public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null || m == n)
			return head;

		int count = 1;
		ListNode movingIndex = head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode previous = dummy;
		
		ListNode reversedPartTail = dummy;
		ListNode temp = dummy;
		
		while (movingIndex != null) {
			if (count < m) {
				count++;
				movingIndex = movingIndex.next;
				previous = previous.next;
			}
			
			if(count == m)
			{
				reversedPartTail = movingIndex;
				temp = movingIndex.next.next;
				movingIndex.next.next = movingIndex;
				movingIndex = movingIndex.next;
				count++;
				
			}
			
			if(count > m && count <= n)
			{
				
			}
		}

		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
