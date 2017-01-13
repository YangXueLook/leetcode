import java.util.ArrayList;

public class SumRootToLeafNumbers {
	public ArrayList<String> rootToLeafString(TreeNode root) {
		ArrayList<String> result = new ArrayList<String>();

		if (root == null) {
			result.add("");
			return result;
		} else if (root.left == null && root.right == null) {
			result.add(Integer.toString(root.val));
			return result;
		}

		else if (root.left == null) {
			ArrayList<String> resultR = rootToLeafString(root.right);
			for (int i = 0; i < resultR.size(); i++) {
				result.add(Integer.toString(root.val) + resultR.get(i));
			}
			return result;

		}

		else if (root.right == null) {
			ArrayList<String> resultL = rootToLeafString(root.left);
			for (int i = 0; i < resultL.size(); i++) {
				result.add(Integer.toString(root.val) + resultL.get(i));
			}
			return result;

		} else {
			ArrayList<String> resultR = rootToLeafString(root.right);
			for (int i = 0; i < resultR.size(); i++) {
				result.add(Integer.toString(root.val) + resultR.get(i));
			}
			ArrayList<String> resultL = rootToLeafString(root.left);
			for (int i = 0; i < resultL.size(); i++) {
				result.add(Integer.toString(root.val) + resultL.get(i));
			}
			return result;
		}

	}

	public int sumNumbers(TreeNode root) {
		ArrayList<String> strings = rootToLeafString(root);
		int result = 0;
		

		for (int i = 0; i < strings.size(); i++) {
			result = result + Integer.parseInt(strings.get(i));
		}

		return result;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);

		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);

		t1.left = t2;
		t1.right = t3;

		SumRootToLeafNumbers t = new SumRootToLeafNumbers();

		System.out.println(t.sumNumbers(t1));
	}

}
