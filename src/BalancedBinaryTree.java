public class BalancedBinaryTree {

	public int treeHeight(TreeNode root) {
		if (root == null)
			return 0;

		return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;

		if (Math.abs(treeHeight(root.left) - treeHeight(root.right)) > 1)
			return false;

		return isBalanced(root.left) && isBalanced(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
