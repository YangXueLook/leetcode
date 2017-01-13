public class MinDepth {

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		else if (root.left == null && root.right == null)
			return 0;

		else
			return 1 + Math.min(minDepth(root.left), minDepth(root.right));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
