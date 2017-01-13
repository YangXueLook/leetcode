import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClear {

	public List<List<Integer>> threeSum(int[] nums) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			ArrayList<ArrayList<Integer>> towSumResult = twosum(nums, i + 1,
					-nums[i]);
			for (ArrayList<Integer> list : towSumResult) {
				list.add(0, nums[i]);
				result.add(list);
			}
		}

		return result;

	}

	private ArrayList<ArrayList<Integer>> twosum(int[] nums, int startIndex,
			int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int i = startIndex;
		int j = nums.length - 1;

		while (i < j) {
			if (nums[i] + nums[j] == target) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(nums[i]);
				list.add(nums[j]);
				i++;
				j--;

				result.add(list);
			} else if (nums[i] + nums[j] < target)
				i++;
			else
				j--;
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] { 7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14,
				-4, -5, 7, 9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6,
				11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6,
				-15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1,
				-9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12,
				14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12,
				13, -7, -12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6 };
		
		ThreeSumClear t = new ThreeSumClear();
		List<List<Integer>> result = t.threeSum(array);
		for(List<Integer> list: result)
		{
			System.out.println();
			for(Integer e: list)
			{
				System.out.print(e+"\t");
			}
		}
			

	}

}
