
public class RecoverBinarySearchTree {

	public static TreeNode preNode = null;
	public static TreeNode firstNode = null;
	public static TreeNode secondNode = null;
	public static boolean detectedBefore = false;

	public void inorderTraverse(TreeNode root, TreeNode pre) {
		if (root == null)
			return;

		inorderTraverse(root.left, preNode);
		if (preNode == null) {
			preNode = root;
			System.out.println(root.val + "++++ " + preNode.val);
		}

		else {
			System.out.println(root.val + "---- " + preNode.val);
			if (preNode.val > root.val) {
				if (!detectedBefore) {
					firstNode = preNode;
					secondNode = root;
					detectedBefore = true;
				} else {
					secondNode = root;
				}
			}
			preNode = root;
		}

		inorderTraverse(root.right, preNode);
	}

	public void recoverTree(TreeNode root) {

		inorderTraverse(root, preNode);

		int temp = firstNode.val;

		firstNode.val = secondNode.val;
		secondNode.val = temp;

	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(1);

		a.right = b;
		RecoverBinarySearchTree t = new RecoverBinarySearchTree();

		t.recoverTree(a);

		System.out.println(a.val + "  " + a.right.val);

	}

}
