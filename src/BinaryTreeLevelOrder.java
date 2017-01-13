import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrder {

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		ArrayList<TreeNode> currentLevelNodes = new ArrayList<TreeNode>();
		ArrayList<TreeNode> nextLevelNodes = new ArrayList<TreeNode>();
		currentLevelNodes.add(root);

		

		while (!currentLevelNodes.isEmpty()) {
			nextLevelNodes.clear();
			ArrayList<Integer> currentLevelValue = new ArrayList<Integer>();
			for (int i = 0; i < currentLevelNodes.size(); i++) {
				currentLevelValue.add(currentLevelNodes.get(i).val);
				if(currentLevelNodes.get(i).left != null)
					nextLevelNodes.add(currentLevelNodes.get(i).left);
				if(currentLevelNodes.get(i).right != null)
					nextLevelNodes.add(currentLevelNodes.get(i).right);
			}
			result.add(currentLevelValue);
			
			currentLevelNodes = (ArrayList<TreeNode>) nextLevelNodes.clone();
		}

		return result;
	}

	public static void main(String[] args) {
		ArrayList<TreeNode> currentLevelNodes = new ArrayList<TreeNode>();
		currentLevelNodes.add(null);
		currentLevelNodes.add(null);
		currentLevelNodes.clear();
		System.out.println(currentLevelNodes.size());

	}

}
