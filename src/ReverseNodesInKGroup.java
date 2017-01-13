public class ReverseNodesInKGroup {
	
	public ListNode reverseNodesInWindow(ListNode head)
	{
		if(head == null || head.next == null)
			return head;
		ListNode p1 = head;
		ListNode p2 = head.next;
		ListNode temp;
		
		while(p2!= null)
		{
			temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}
		
		head.next = null;
		
		return p1;
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || head.next == null|| k <= 1)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode finishedPartTail = dummy;
		ListNode processingPartHead = head;
		ListNode processingPartTail;
		ListNode originalParthead;
		ListNode movingIndex;
		ListNode tempTail = new ListNode(0);
		boolean finished = false;
		while(!finished)
		{
			
			if(processingPartHead == null)
				break;
			movingIndex = processingPartHead;
			for(int i = 1; i < k; i++)
			{
				if(movingIndex.next != null)
				{
					
					movingIndex = movingIndex.next;
				}
				else
				{
					finished = true;
				}
			}
			if(!finished)
			{
				
				processingPartTail = movingIndex;
				
				originalParthead = processingPartTail.next;
				processingPartTail.next = null;
				processingPartHead = reverseNodesInWindow(processingPartHead);
				tempTail = processingPartHead;
				while(tempTail.next != null)
				{
					tempTail = tempTail.next;
				}
				
				tempTail.next = originalParthead;
				
				finishedPartTail.next = processingPartHead;
				
				finishedPartTail = tempTail;
				processingPartHead = finishedPartTail.next;
				
				
			}
			else
				return dummy.next;
		}
		
		
		

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode t1 = new ListNode(1);
		ListNode t2 = new ListNode(2);
		ListNode t3 = new ListNode(3);
		ListNode t4 = new ListNode(4);
		ListNode t5 = new ListNode(5);
		t1.next = t2;
		t2.next = t3;
		t3.next = t4;
		t4.next = t5;
		
		ReverseNodesInKGroup t = new ReverseNodesInKGroup();
		ListNode result =  t.reverseKGroup(t1, 3);
		while(result!=null)
		{
			System.out.println(result.val);
			result = result.next;
		}
		

	}

}
