import java.util.ArrayList;
import java.util.HashMap;

public class MaxLenSubArraySumToK {

	public int maxSubArrayLen(int[] nums, int k) {
		int[] sumArray = new int[nums.length];
		int sum = 0;
		for(int i = 0; i < nums.length; i++)
		{
			sum = sum + nums[i];
			sumArray[i] = sum;
		}
		
		HashMap<Integer, ArrayList<Integer>> sumAndIndiceMap = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 0; i < nums.length; i++)
		{
			if(sumAndIndiceMap.containsKey(sumArray[i]))
			{
				sumAndIndiceMap.get(sumArray[i]).add(i);
			}
			else
			{
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				sumAndIndiceMap.put(sumArray[i], list);
			}
		}
		
		int result = 0;
		for(int i = nums.length - 1; i >= 0; i--)
		{
			if(k == sumArray[i])
				return i;
			
			int key = sumArray[i] - k;
			
			if(sumAndIndiceMap.containsKey(key))
			{
				result = Math.max(result, i - sumAndIndiceMap.get(key).get(0) + 1);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
