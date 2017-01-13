import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public boolean isValidStatus(int[] currentChessBoardStatus,
			int varificationBound) {
		for (int i = 0; i < varificationBound; i++) {
			if (currentChessBoardStatus[i] == currentChessBoardStatus[varificationBound])
				return false;
			if (Math.abs(currentChessBoardStatus[i]
					- currentChessBoardStatus[varificationBound]) == Math.abs(i
					- varificationBound))
				return false;
		}

		return true;
	}

	public void assistant(int n, int currentFillingRow,
			int[] currentChessBoardStatus, ArrayList<String[]> result) {
		if (currentFillingRow < n) {
			for (int i = 0; i < n; i++) {
				currentChessBoardStatus[currentFillingRow] = i;
				if (isValidStatus(currentChessBoardStatus, currentFillingRow)) {
					assistant(n, currentFillingRow + 1,
							currentChessBoardStatus, result);
				}

			}
		} else {
			String[] oneValidResult = new String[n];
			for (int i = 0; i < n; i++) {
				StringBuffer temp = new StringBuffer();
				for (int j = 0; j < n; j++)
					temp.append(".");
				temp.setCharAt(currentChessBoardStatus[i], 'Q');
				oneValidResult[i] = temp.toString();
			}
			result.add(oneValidResult);

		}

	}

	public List<String[]> solveNQueens(int n) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		int[] currentChessBoardStatus = new int[n];
		int currentFillingRow = 0;
		assistant(n, currentFillingRow, currentChessBoardStatus, result);

		return result;
	}

	public static void main(String[] args) {
		NQueens t = new NQueens();
		ArrayList<String[]> result = (ArrayList<String[]>) t.solveNQueens(8);
		for(int i = 0; i < result.size(); i++)
		{
			for(int j = 0; j < result.get(i).length; j++)
			{
				System.out.println(result.get(i)[j]);
			}
			System.out.println("---------------");
		}

	}

}
