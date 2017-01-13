import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

	public List<List<Integer>> combinationSum3(int k, int n) {
		
		return helper(k, n, 9);
		
	}

	private List<List<Integer>> helper(int k, int n, int end) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(end == 0)
			return result;
		
		if(k == 1)
		{
			if(n <= end)
			{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(n);
				result.add(temp);
				return result;
			}
			else
				return result;
		}
		else
		{
			if(n > end)
			{
				List<List<Integer>> tempResult1 = helper(k - 1, n - end, end - 1);
				
				for(int i = 0; i < tempResult1.size(); i++)
				{
					tempResult1.get(i).add(end);
					result.add(tempResult1.get(i));
				}
				
				List<List<Integer>> tempResult2 = helper(k, n, end - 1);
				for(int i = 0; i < tempResult2.size(); i++)
				{
					result.add(tempResult2.get(i));
				}
			}
			else
			{
				List<List<Integer>> tempResult2 = helper(k, n, end - 1);
				for(int i = 0; i < tempResult2.size(); i++)
				{
					result.add(tempResult2.get(i));
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumIII t = new CombinationSumIII();
		List<List<Integer>> result = t.combinationSum3(1, 9);
		for(int i = 0; i < result.size(); i++)
		{
			for(int j = 0; j < result.get(i).size(); j++)
				System.out.print(result.get(i).get(j));
			System.out.println();
		}

	}

}
