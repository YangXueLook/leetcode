public class RemoveNthNodeFromEndofList {

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		// if only 1 node, then n must be 1, result must be null
		if (head.next == null)
			return null;

		// if n == 1, then just remove the last node
		else if (n == 1) {
			ListNode pioneer = head.next;
			ListNode follower = head;
			while (pioneer.next != null) {
				pioneer = pioneer.next;
				follower = follower.next;
			}
			follower.next = null;
			return head;
		} else {
			ListNode pioneer = head;
			ListNode follower = head;
			ListNode prefollwer = follower;
			for (int i = 0; i < n - 1; i++)
				pioneer = pioneer.next;

			while (pioneer.next != null) {
				pioneer = pioneer.next;
				prefollwer = follower;
				follower = follower.next;
			}
			if (follower == head)
				head = head.next;

			else
				prefollwer.next = follower.next;

			return head;
		}

	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode result = removeNthFromEnd(a, 1);

		System.out.println(result.val);

	}

}
