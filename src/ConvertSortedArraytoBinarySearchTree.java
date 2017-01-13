public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode assistant(int[] num, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode t = new TreeNode(num[mid]);

		t.left = assistant(num, start, mid - 1);
		t.right = assistant(num, mid + 1, end);

		return t;
	}

	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null)
			return null;

		return assistant(num, 0, num.length - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
