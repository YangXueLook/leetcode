import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		ArrayList<TreeNode> currentLevelNodes = new ArrayList<TreeNode>();
		ArrayList<TreeNode> nextLevelNodes = new ArrayList<TreeNode>();
		currentLevelNodes.add(root);

		boolean fromLeftToRight = true;

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
			if (fromLeftToRight)
				result.add(currentLevelValue);
			else {
				int i = 0;
				int j = currentLevelValue.size() - 1;
				while (i < j) {
					int temp = currentLevelValue.get(i);
					currentLevelValue.set(i, currentLevelValue.get(j));
					currentLevelValue.set(j, temp);
					i++;
					j--;
				}
				result.add(currentLevelValue);
			}

			currentLevelNodes = (ArrayList<TreeNode>) nextLevelNodes.clone();
			fromLeftToRight = !fromLeftToRight;
		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
