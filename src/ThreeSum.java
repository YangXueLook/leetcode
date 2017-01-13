import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static List<List<Integer>> twoSum(int[] num, int target,
			int startIndex, int endIndex) {
		Set<List<Integer>> set = new HashSet<List<Integer>>();

		int[] uniqueArray = num;

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = startIndex, j = endIndex; i < j;) {
			if ((uniqueArray[i] + uniqueArray[j]) == target) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(uniqueArray[i]);
				temp.add(uniqueArray[j]);
				result.add(temp);
				j--;
				i++;
			} else if ((uniqueArray[i] + uniqueArray[j]) > target)

				j--;

			else
				i++;
		}

		for (int i = 0; i < result.size(); i++) {
			set.add(result.get(i));
		}
		result.clear();
		Object[] objArray = set.toArray();
		for (int i = 0; i < objArray.length; i++) {
			result.add((List<Integer>) objArray[i]);
		}

		return result;
	}

	public static List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		
		Arrays.sort(num);

		for (int i = 0; i < num.length - 2; i++) {
			int currentTarget = -num[i];
			List<List<Integer>> twoSumResult = twoSum(num, currentTarget,
					i + 1, num.length - 1);

			for (int m = 0; m < twoSumResult.size(); m++) {
				twoSumResult.get(m).add(num[i]);
				Collections.sort(twoSumResult.get(m));
				result.add(twoSumResult.get(m));
			}
		}

		for (int i = 0; i < result.size(); i++) {
			set.add(result.get(i));
		}
		result.clear();
		Object[] objArray = set.toArray();
		for (int i = 0; i < objArray.length; i++) {
			result.add((List<Integer>) objArray[i]);
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] num = new int[] { -1, -1, 1, 1, 2, 3, 4, 5, 6, 7, -12 };
		// List<List<Integer>> result = twoSum(num, 8, 0, num.length - 1);

		List<List<Integer>> result = threeSum(num);
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + "\t");
			}
			System.out.println();
		}

	}

}
