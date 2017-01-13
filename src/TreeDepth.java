public class TreeDepth {

	public int maxDepth(TreeNode root) {

		if (root == null)
			return 0;
		else
			return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}