public class ConvertSorteListtoBinarySearchTree {

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null) {
			System.out.println("legnth = 1  " + head.val);
			TreeNode t = new TreeNode(head.val);
			return t;
		}

		ListNode dummy = new ListNode(0);

		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = dummy;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		int rootValue = slow.next.val;
		ListNode secondHalfhead = slow.next.next;

		slow.next = null;

		TreeNode root = new TreeNode(rootValue);
		System.out.println(head.val + " ----------" + secondHalfhead.val);
		TreeNode leftChild = sortedListToBST(head);
		TreeNode rightChild = sortedListToBST(secondHalfhead);

		root.left = leftChild;
		root.right = rightChild;

		return root;

	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		ListNode l2 = new ListNode(5);
		ListNode l3 = new ListNode(8);

		l1.next = l2;
		l2.next = l3;

		ConvertSorteListtoBinarySearchTree a = new ConvertSorteListtoBinarySearchTree();

		ConvertSorteListtoBinarySearchTree test = new ConvertSorteListtoBinarySearchTree();

		TreeNode t = test.sortedListToBST(l1);

		System.out.println(t.val);
		System.out.println(t.left.val);
		System.out.println(t.right.val);

	}
}
