import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class PathSumII {

	public static List<List<Integer>> result = new ArrayList<List<Integer>>();

	public static Stack<TreeNode> s = new Stack<TreeNode>();

	public static void hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return;
		s.push(root);

		if (root.right == null && root.left == null) {
			if (root.val == sum) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for (int i = 0; i < s.size(); i++) {
					temp.add(s.get(i).val);
				}
				result.add(temp);
			}
		}

		else {
			hasPathSum(root.left, sum - root.val);
			hasPathSum(root.right, sum - root.val);
		}
		s.pop();

	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		hasPathSum(root, sum);

		return result;
	}

	public static void main(String[] args) {
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		r1.left = r2;
		r1.right = r3;
		
		pathSum(r1, 5);

		System.out.println(result.size());

	}

}
