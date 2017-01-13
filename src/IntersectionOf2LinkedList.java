public class IntersectionOf2LinkedList {
	
	public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
			return null;

		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
			{
			    fast = head;
			    while(fast != slow)
			    {
			        fast = fast.next;
			        slow = slow.next;
			    }
			    return fast;
			    
			}
		}

		return null;
    }

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		ListNode indexA = headA;
		ListNode indexB = headB;

		while (indexA.next != null)
			indexA = indexA.next;

		while (indexB.next != null)
			indexB = indexB.next;

		if (indexA != indexB)
			return null;
		
		indexA.next = headA;
		
		ListNode result = detectCycle(headB);
		
		indexA.next = null;
		

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
