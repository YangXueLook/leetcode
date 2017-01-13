public class ValidBinarySearchTree {

	public boolean isValidWithBound(TreeNode root, int low, int high) {

		if (root == null)
			return true;
		if (root.val <= low || root.val >= high)
			return false;

		if (root.left == null && root.right == null)
			return true;

		if (root.left != null && root.val < root.left.val)
			return false;
		if (root.right != null && root.val > root.right.val)
			return false;

		return isValidWithBound(root.left, low, root.val)
				&& isValidWithBound(root.right, root.val, high);

	}

	public boolean isValidBST(TreeNode root) {

		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		if (root.left != null && root.val < root.left.val)
			return false;
		if (root.right != null && root.val > root.right.val)
			return false;

		return isValidWithBound(root.left, Integer.MIN_VALUE, root.val)
				&& isValidWithBound(root.right, root.val, Integer.MAX_VALUE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
