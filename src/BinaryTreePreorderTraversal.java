import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();

		while (!(root == null && s.isEmpty())) {
			while (root != null) {
				result.add(root.val);
				s.push(root);
				root = root.left;
			}
			if (!s.isEmpty()) {
				root = s.pop();
				
				root = root.right;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
