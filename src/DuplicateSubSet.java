import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DuplicateSubSet {

	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		int size = S.length;
		int subSetsNum = (int) Math.pow(2, size);
		for (int i = subSetsNum - 1; i >= 0; i--) {
			List<Integer> subSetInEachInteration = new ArrayList<Integer>();
			for (int j = 0; j < size; j++) {
				int temp = (int) Math.pow(2, j);
				if ((i & temp) != 0) {
					subSetInEachInteration.add(S[j]);
				}

			}
			Collections.sort(subSetInEachInteration);
			result.add(subSetInEachInteration);
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
