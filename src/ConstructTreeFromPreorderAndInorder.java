public class ConstructTreeFromPreorderAndInorder {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0)
			return null;

		return assistant(preorder, 0, preorder.length - 1, inorder, 0,
				preorder.length - 1);
	}

	public TreeNode assistant(int[] preorder, int s1, int e1, int[] inorder,
			int s2, int e2) {

		System.out.println("s1 = " + s1 + "  e1 = " + e1);
		System.out.println("s2 = " + s2 + "  e2 = " + e2);
		System.out.println("----------------------");

		if (s1 > e1 || s2 > e2) {

			return null;
		}

		if (s1 == e1)
			return new TreeNode(preorder[s1]);
		else if ((e1 - s1) == 1) {
			if (preorder[s1] == inorder[s2]) {
				TreeNode root = new TreeNode(preorder[s1]);
				TreeNode right = new TreeNode(preorder[e1]);
				root.right = right;
				return root;
			} else {
				TreeNode root = new TreeNode(preorder[s1]);
				TreeNode left = new TreeNode(preorder[e1]);
				root.left = left;
				return root;
			}
		}

		else {
			int leftLength = 0;
			for (int i = s2; i <= e2; i++) {

				if (inorder[i] == preorder[s1]) {
					break;
				}
				leftLength++;
			}
			TreeNode root = new TreeNode(preorder[s1]);
			TreeNode left = assistant(preorder, s1 + 1, s1 + leftLength,
					inorder, s2, s2 + leftLength - 1);
			TreeNode right = assistant(preorder, s1 + leftLength + 1, e1,
					inorder, s2 + leftLength + 1, e2);

			root.left = left;
			root.right = right;
			return root;

		}

	}

	public static void main(String[] args) {
		int[] preorder = new int[] { 5, 4, 1, 2, 3 };
		int[] inorder = new int[] { 1, 2, 3, 4, 5 };
		ConstructTreeFromPreorderAndInorder a = new ConstructTreeFromPreorderAndInorder();
		TreeNode root = a.buildTree(preorder, inorder);
		// System.out.println(root.val);
		//
		// System.out.println(root.right.val);
		// System.out.println(root.right.right.val);
		// System.out.println(root.right.right.right.val);

		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.left.left.val);
		System.out.println(root.left.right.val);
		System.out.println(root.right.val);
		System.out.println(root.right.right.val);

	}
}
