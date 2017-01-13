import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSumII {

	public List<List<Integer>> assitant(int[] num, int target, int endIndex) {
//		List<List<Integer>> result = new ArrayList<List<Integer>>();
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		if (endIndex == 0) {
			if (num[endIndex] == target) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(num[endIndex]);
				set.add(temp);
			}
			return new ArrayList<List<Integer>>(set);
		} else {
			if (target < num[endIndex]) {
				return assitant(num, target, endIndex - 1);
			}
			else if(target == num[endIndex])
			{
				ArrayList<List<Integer>> temp1 = (ArrayList<List<Integer>>) assitant(
						num, target, endIndex - 1);
//				result = temp1;
				set = new HashSet<List<Integer>>(temp1);
				
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(num[endIndex]);
				set.add(temp);
				
				return new ArrayList<List<Integer>>(set);
			}
			
			else {
				ArrayList<List<Integer>> temp1 = (ArrayList<List<Integer>>) assitant(
						num, target, endIndex - 1);
//				result = temp1;
				set = new HashSet<List<Integer>>(temp1);
				ArrayList<List<Integer>> temp2 = (ArrayList<List<Integer>>) assitant(
						num, target - num[endIndex], endIndex - 1);
				for (int i = 0; i < temp2.size(); i++) {
					temp2.get(i).add(num[endIndex]);
					set.add(temp2.get(i));
				}
				return new ArrayList<List<Integer>>(set);
			}
		}

	}

	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0)
			return result;
		Arrays.sort(num);

		return assitant(num, target, num.length - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumII t = new CombinationSumII();
		int[] num = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;

		ArrayList<List<Integer>> result = (ArrayList<List<Integer>>) t
				.combinationSum2(num, target);
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++)
				System.out.print(result.get(i).get(j));
			System.out.println();
		}
	}

}
