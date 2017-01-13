import java.util.ArrayList;

public class PointToRight {

	public static void connect(TreeLinkNode root) {
		if (root == null)
			return;
		ArrayList<TreeLinkNode> currentLayer = new ArrayList<TreeLinkNode>();
		ArrayList<TreeLinkNode> nextLayer = new ArrayList<TreeLinkNode>();

		currentLayer.add(root);

		while (!currentLayer.isEmpty()) {
//			for (int i = 0; i < currentLayer.size(); i++) {
//				System.out.print(currentLayer.get(i).val + "\t");
//
//			}
//			System.out.println();
			nextLayer.clear();
			for (int i = 0; i < currentLayer.size(); i++) {
				if (i == currentLayer.size() - 1) {
					currentLayer.get(i).next = null;
					System.out.println("aaa");
				} else {
					currentLayer.get(i).next = currentLayer.get(i + 1);
					System.out.println("bbb");
				}

				if (currentLayer.get(i).left != null) {
					nextLayer.add(currentLayer.get(i).left);
				}

				if (currentLayer.get(i).right != null) {
					nextLayer.add(currentLayer.get(i).right);
				}

			}

			// for (int i = 0; i < nextLayer.size(); i++) {
			// System.out.print(nextLayer.get(i).val + "\t");
			//
			// }
			// System.out.println();
			// currentLayer = (ArrayList<TreeLinkNode>) nextLayer.clone();
			currentLayer.clear();
			for (int i = 0; i < nextLayer.size(); i++) {
				currentLayer.add(nextLayer.get(i));
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode t1 = new TreeLinkNode(1);
		TreeLinkNode t2 = new TreeLinkNode(2);
		TreeLinkNode t3 = new TreeLinkNode(3);
		t1.left = t2;
		t1.right = t3;

		connect(t1);

		System.out.println(t2.next);

	}

}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}