public class CountCompleteTreeNodes {
	
	private TreeNode findNodeAtLayerIndex(TreeNode root, int layer, int index)
	{
		int mask = (int) Math.pow(2, layer - 2);
		TreeNode result = root;
		for(int i = 1; i < layer; i++)
		{
			if((index & mask) == 0)
				result = result.left;
			else
				result = result.right;
			mask = mask/2;
		}
		
		
		return result;
	}
	
	
	public int countNodes(TreeNode root) {
		if(root == null)
			return 0;
		
		TreeNode index = root;
		int depth = 1;
		while(index.left != null)
		{
			depth++;
			index = index.left;
		}
		
		if(depth == 1)
			return 1;
		
		int nodesBeforelastLayer = (int) Math.pow(2, depth - 1) - 1;
		
		int start = 0;
		int end = (int) Math.pow(2, depth - 1) - 1;
		int mid = (start + end)/2;
		
		while(start < end)
		{
			
			
//			System.out.println(start+" "+end+" "+mid);
			
			if(findNodeAtLayerIndex(root, depth, end) != null)
			{
				mid = end;
				break;
			}
			mid = (start + end)/2;
			
			if(findNodeAtLayerIndex(root, depth, mid) == null)
			{
				end = mid;
//				mid = (start + end)/2;
			}
			else
			{
				start = mid;
//				mid = (start + end)/2;
				if(findNodeAtLayerIndex(root, depth, mid + 1) == null)
					break;
			}
		}
//		if(findNodeAtLayerIndex(root, depth, end) != null)
//			mid++;
		
		return nodesBeforelastLayer + mid + 1;
	}

	public static void main(String[] args) {
		CountCompleteTreeNodes t = new CountCompleteTreeNodes();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(1);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(1);
		TreeNode t6 = new TreeNode(1);
		
		t1.left = t2;
		t1.right = t3;
		
		t2.left =t4;
//		t2.right = t5;
//		t3.left = t6;
		
//		System.out.println(t.findNodeAtLayerIndex(t1, 2, 0));

		System.out.println(t.countNodes(t1));
	}

}
