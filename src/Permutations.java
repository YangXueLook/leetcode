import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (num.length == 0)
			return result;
		if (num.length == 1) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(num[0]);
			result.add(temp);
			return result;
		}

		else {
			int[] subarray = Arrays.copyOfRange(num, 0, num.length - 1);
			List<List<Integer>> tempResult = permute(subarray);
			ArrayList<Integer> temp;
			for (int i = 0; i < tempResult.size(); i++) {
				temp = (ArrayList<Integer>) tempResult.get(i);

				for (int j = 0; j <= temp.size(); j++) {
					ArrayList<Integer> clone = (ArrayList<Integer>) temp
							.clone();
					clone.add(j, num[num.length - 1]);
					result.add(clone);

				}

			}
			return result;

		}

	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 5 };
		int[] b = Arrays.copyOfRange(a, 0, a.length - 1);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]);
		}
	}

}
