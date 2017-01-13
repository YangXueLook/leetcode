import java.util.ArrayList;

public class NQueensII {
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

	public int totalNQueens(int n) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		int[] currentChessBoardStatus = new int[n];
		int currentFillingRow = 0;
		assistant(n, currentFillingRow, currentChessBoardStatus, result);

		return result.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
