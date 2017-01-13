import java.util.ArrayList;

public class LCA {
	
	static class MyTree
	{
		int val;
		MyTree left = new MyTree();
		MyTree right = new MyTree();
		ArrayList<Integer> ancestorList = new ArrayList<Integer>();
	}
	
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null)
			return null;
		if(root.val == p.val || root.val == q.val)
			return root;
		
		TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
		TreeNode rightResult = lowestCommonAncestor(root.right, p, q);
		
		if(leftResult != null && rightResult != null)
			return root;
		
		else 
			return leftResult == null? rightResult: leftResult;
		
    }

	private void build(MyTree myRoot, TreeNode root) {
		if(root == null)
			return;
		
		
	}

	public static void main(String[] args) {
		

	}
}
