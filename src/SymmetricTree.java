public class SymmetricTree {

	public boolean isMirror(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null && q != null || p != null && q == null)
			return false;
		if (p.val != q.val)
			return false;

		return isMirror(p.left, q.right) && isMirror(p.right, q.left);
	}

	public boolean isSymmetric(TreeNode root) {

		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		if (root.left == null && root.right != null || root.left != null
				&& root.right == null)
			return false;
		if (root.left.val != root.left.val)
			return false;

		return isMirror(root.left, root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
