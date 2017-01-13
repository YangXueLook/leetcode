import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static List<List<Integer>> generate(int numRows) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = 1; i <= numRows; i++) {
			List<Integer> currentRow = new ArrayList<Integer>();
			if (i == 1) {
				currentRow.add(1);
			}
			else if (i == 2) {
				currentRow.add(1);
				currentRow.add(1);
			} else {
				currentRow.add(1);
				for (int j = 2; j <= i - 1; j++) {
					currentRow.add(result.get(i - 2).get(j - 2)
							+ result.get(i - 2).get(j - 1));
				}
				currentRow.add(1);
			}

			result.add(currentRow);
		}

		return result;

	}

	public static void main(String[] args) {
		List<List<Integer>> a = generate(5);
		for(int i = 0; i < a.size(); i++)
		{
			for(int j = 0; j < a.get(i).size(); j++)
			{
				System.out.print(a.get(i).get(j)+"\t");
				
			}
			System.out.println("---------");
		}
		
		
		
		
		
		
		

	}

}
