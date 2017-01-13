import java.util.Stack;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;

		if (root.right == null && root.left == null && root.val == sum)
			return true;

		return hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
