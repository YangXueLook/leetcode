import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinaryTreeVerticalOrderTraversal {

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null)
			return result;
		
		
		ArrayList<XYVal> list = new ArrayList<XYVal>();
		
		helper(root, list, 0, 0);
		
		Collections.sort(list, new Comparator<XYVal>(){

			@Override
			public int compare(XYVal o1, XYVal o2) {
				if(o1.x != o2.x)
					return o1.x - o2.x;
				else
					return o1.y - o2.y;
			}});
		
		int currentX = list.get(0).x;
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(list.get(0).val);
		result.add(l);
		for(int i = 1; i < list.size() - 1; i++)
		{
			if(list.get(i).x == currentX)
			{
				result.get(result.size() - 1).add(list.get(i).val);
			}
			else
			{
				currentX = list.get(i).x;
				ArrayList<Integer> newL = new ArrayList<Integer>();
				newL.add(list.get(i).val);
				result.add(newL);
				
			}
		}
		
		if(list.size() > 1)
		{
			if(list.get(list.size() - 1).x == currentX)
			{
				result.get(result.size() - 1).add(list.get(list.size() - 1).val);
			}
			else
			{
				ArrayList<Integer> newL = new ArrayList<Integer>();
				newL.add(list.get(list.size() - 1).val);
				result.add(newL);
			}
		}
		
		
		
		return result;
	}

	private void helper(TreeNode root, ArrayList<XYVal> list, int currentX, int currentY) {
		if(root == null)
			return;
		helper(root.left, list, currentX - 1, currentY + 1);
		
		XYVal r = new XYVal();
		r.x = currentX;
		r.y = currentY;
		r.val = root.val;
		list.add(r);
		
		helper(root.right, list, currentX + 1, currentY + 1);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class XYVal
{
	int x;
	int y;
	int val;
}