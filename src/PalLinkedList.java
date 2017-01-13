public class PalLinkedList {

	public boolean isPalindrome(ListNode head) {
		int length = 0;
		ListNode movingIndex = head;
		while(movingIndex != null)
		{
			length++;
			movingIndex = movingIndex.next;
		}
		
		if(length == 2)
			return head.val == head.next.val;
		
		ListNode preMovingIndex = head;
		movingIndex = head.next;
		
		for(int i = 0; i< length/2; i++)
		{
			preMovingIndex = preMovingIndex.next;
			movingIndex = movingIndex.next;
		}
		
		ListNode afterMovingIndex = movingIndex.next;
		while(afterMovingIndex != null)
		{
			movingIndex.next = preMovingIndex;
			preMovingIndex = movingIndex;
			movingIndex = afterMovingIndex;
			afterMovingIndex = afterMovingIndex.next;
		}
		movingIndex.next = preMovingIndex;
		
		for(int i = 0; i < length/2; i++)
		{
			if(head.val != movingIndex.val)
				return false;
			
			head = head.next;
			movingIndex = movingIndex.next;
		}
		
		

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
