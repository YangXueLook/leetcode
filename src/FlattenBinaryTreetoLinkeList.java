public class FlattenBinaryTreetoLinkeList {
	public void flatten(TreeNode root) {
		if(root  == null)
			return;
		if(root.right == null)
		{
			root.right = root.left;
			root.left = null;
			flatten(root.right);
		}
		if(root.left == null)
		{
			flatten(root.right);
		}
		else
		{
			flatten(root.left);
			flatten(root.right);
			TreeNode leftSubTreeRightMost = root.left;
			while(leftSubTreeRightMost.right != null)
			{
				leftSubTreeRightMost = leftSubTreeRightMost.right;
			}
			leftSubTreeRightMost.right = root.right;
			root.right = root.left;
			root.left = null;
			
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
