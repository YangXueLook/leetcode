import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> tempResult = new ArrayList<List<Integer>>();
		if (root == null) {
			return tempResult;
		}
		ArrayList<TreeNode> currentLevelNodes = new ArrayList<TreeNode>();
		ArrayList<TreeNode> nextLevelNodes = new ArrayList<TreeNode>();
		currentLevelNodes.add(root);

		while (!currentLevelNodes.isEmpty()) {
			nextLevelNodes.clear();
			ArrayList<Integer> currentLevelValue = new ArrayList<Integer>();
			for (int i = 0; i < currentLevelNodes.size(); i++) {
				currentLevelValue.add(currentLevelNodes.get(i).val);
				if (currentLevelNodes.get(i).left != null)
					nextLevelNodes.add(currentLevelNodes.get(i).left);
				if (currentLevelNodes.get(i).right != null)
					nextLevelNodes.add(currentLevelNodes.get(i).right);
			}
			tempResult.add(currentLevelValue);

			currentLevelNodes = (ArrayList<TreeNode>) nextLevelNodes.clone();
		}

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = tempResult.size() - 1; i >= 0; i--) {
			result.add(tempResult.get(i));
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
