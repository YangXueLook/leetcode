import java.util.ArrayList;
import java.util.List;

public class PascalII {

	public static List<Integer> getRow(int rowIndex) {

		int rowIndexFromOne = rowIndex+1;
		
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> previousRow = new ArrayList<Integer>();
		if (rowIndexFromOne == 1) {
			result.add(1);

		}

		else if (rowIndexFromOne == 2) {
			result.add(1);
			result.add(1);
		} else {
			result.add(1);
			result.add(1);
			for (int i = 3; i <= rowIndexFromOne; i++) {
				
				previousRow.clear();
				for(int j = 0; j <result.size(); j++)
					previousRow.add(result.get(j));

				result.clear();

				result.add(1);

				

				for (int j = 2; j <= i - 1; j++) {

					result.add(previousRow.get(j - 2) + previousRow.get(j - 1));
				}
				result.add(1);
			}
		}

		return result;
	}

	public static void main(String[] args) {

		List<Integer> a = getRow(3);
		for (int j = 0; j < a.size(); j++) {
			System.out.print(a.get(j) + "\t");

		}

	}

}
