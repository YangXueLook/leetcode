import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		if(nums == null || nums.length == 0)
			return new ArrayList<Integer>();
		
		Arrays.sort(nums);
		ArrayList<ArrayList<Integer>> ll = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> first = new ArrayList<Integer>();
		first.add(nums[0]);
		ll.add(first);
		
		for(int i = 0; i < nums.length; i++)
		{
			int preSize = ll.get(i - 1).size();
			
			if(nums[i] % ll.get(i - 1).get(preSize - 1) == 0)
			{
				ll.add(deepCopy(ll.get(i - 1)));
			}
		}
		
		

		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
