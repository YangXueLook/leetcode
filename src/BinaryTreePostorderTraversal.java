import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

	public List<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode current;
		TreeNode pre = root;
		s.push(root);

		while (!(root == null && s.isEmpty())) {
			current = s.peek();

			if ((current.left == null && current.right == null)
					|| pre == current.left || pre == current.right) {
				result.add(current.val);
				s.pop();
				pre = current;
			}

			else {
				if (current.right != null)
					s.push(current.right);
				if (current.left != null)
					s.push(current.left);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
