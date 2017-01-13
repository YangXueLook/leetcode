public class CopyListwithRandomPointer {

	public void duplicate(RandomListNode head) {
		RandomListNode p = head;
		RandomListNode temp;
		while (p != null) {
			temp = p.next;
			RandomListNode newNode = new RandomListNode(p.label);
			p.next = newNode;
			newNode.next = temp;
			p = temp;
		}
	}

	public void buildRandomPointer(RandomListNode head) {
		RandomListNode org = head;
		RandomListNode copied;
		while (org != null) {
			copied = org.next;
			if (org.random != null)
				copied.random = org.random.next;
			else
				copied.random = null;
			org = org.next.next;

		}
	}

	public RandomListNode copyRandomList(RandomListNode head) {

		if (head == null)
			return null;

		duplicate(head);
		buildRandomPointer(head);
		RandomListNode result = head.next;

		RandomListNode org = head;
		RandomListNode copied;

		while (org != null) {
			copied = org.next;
			org.next = copied.next;

			org = copied.next;

			if (org != null)
				copied.next = org.next;
			else
				copied.next = null;
		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}
