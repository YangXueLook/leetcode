import java.util.ArrayList;

public class BSTIterator {

	/**
	 * Your BSTIterator will be called like this: BSTIterator i = new
	 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
	 */

	
	
	private ArrayList<Integer> list = new ArrayList<Integer>();
	private int currentIndex = -1;
	
	private void init(TreeNode root)
	{
		if(root.left != null)
			init(root.left);
		list.add(root.val);
		if(root.right != null)
			init(root.right);
	}

	public BSTIterator(TreeNode root) {
		
		if(root != null)
		{
			init(root);
			currentIndex = 0;
		}
			
		
		
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if(currentIndex == -1||currentIndex == list.size())
			return false;
		else 
			return true;
		
		
	}

	/** @return the next smallest number */
	public int next() {
		currentIndex++;
		return list.get(currentIndex-1);
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		t1.right = t2;
		
		BSTIterator test = new BSTIterator(t1);
		while(test.hasNext())
			System.out.println(test.next());
		

	}

}
