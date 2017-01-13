import java.util.ArrayList;
import java.util.List;

public class Triangle {

	public static int minimumTotal(List<List<Integer>> triangle) {

		int size = triangle.size();

		int[][] resultArray = new int[size][size];
		resultArray[0][0] = triangle.get(0).get(0);

		for (int i = 1; i < size; i++) {

			for (int j = 0; j <= i; j++) {
				if (j == 0)
					resultArray[j][i - j] = resultArray[j][i - j - 1]
							+ triangle.get(i).get(j);
				else if (j == i)
					resultArray[j][i - j] = resultArray[j - 1][i - j]
							+ triangle.get(i).get(j);

				else {
					int min = (resultArray[j][i - j - 1] < resultArray[j - 1][i
							- j]) ? resultArray[j][i - j - 1]
							: resultArray[j - 1][i - j];
					resultArray[j][i - j] = triangle.get(i).get(j)
							+ min;
				}

			}
		}

		int result = Integer.MAX_VALUE;
		for (int i = 0; i < size; i++) {
			if (resultArray[i][size - 1 - i] < result)
				result = resultArray[i][size - 1 - i];
		}
		System.out.println(result);
		return result;

	}

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(2);
		l2.add(3);
		
		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(4);
		l3.add(5);
		l3.add(6);

		triangle.add(l1);
		triangle.add(l2);
		triangle.add(l3);

		minimumTotal(triangle);

	}

}
