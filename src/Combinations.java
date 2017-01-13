import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public static ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

	public static void assistantFunction(int n, int k, int startValue,
			ArrayList<Integer> currentResult) {
		if (k == 0) {

			System.out.println("k == 0");
			result.add(currentResult);
			return;
		}

		else {
			for (int i = startValue; i <= n; i++) {
				ArrayList<Integer> temp = (ArrayList<Integer>) currentResult
						.clone();
				temp.add(i);

				assistantFunction(n, k - 1, i + 1, temp);
			}
		}

	}

	public static List<List<Integer>> combine(int n, int k) {

		ArrayList<Integer> init = new ArrayList<Integer>();

		assistantFunction(n, k, 1, init);

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<List<Integer>> result = (ArrayList<List<Integer>>) combine(2,
				1);
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + "\t");
			}
			System.out.println();
		}
	}
}
