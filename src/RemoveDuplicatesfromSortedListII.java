public class RemoveDuplicatesfromSortedListII {

	public static ListNode deleteDuplicatesII(ListNode head) {
		if (head == null || head.next == null)
			return head;
		
		ListNode dummy = new ListNode(0);
		
		ListNode movingIndex = head;
		ListNode newListIndex = dummy;
		
		int duplicatedValue;
		while (movingIndex != null)
		{
			if(movingIndex.next != null)
			{
				if(movingIndex.val != movingIndex.next.val)
				{
					newListIndex.next = movingIndex;
					newListIndex = movingIndex;
					movingIndex = movingIndex.next;
				}
				else
				{
					duplicatedValue = movingIndex.val;
					while(movingIndex.val == duplicatedValue&&movingIndex.next != null)
					{
						movingIndex = movingIndex.next;
					}
					
					if(movingIndex.next == null)
					{
						if(movingIndex.val != duplicatedValue)
						{
							newListIndex.next = movingIndex;
						}
						else
						{
							newListIndex.next = null;
						}
						return dummy.next;
					}
					
				}
			}
			else{
				newListIndex.next = movingIndex;
				return dummy.next;
			}
			
			
		}
		
		return null;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		ListNode r = deleteDuplicatesII(l1);
		while (r != null) {
			System.out.println(r.val);
			r = r.next;
		}

	}

}
