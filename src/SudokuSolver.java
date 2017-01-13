import java.util.HashSet;

public class SudokuSolver {

	public boolean isValidNewNumber(char[][] board, int x, int y) {

		int row = x;
		int column = y;
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == board[row][column] && i != column) {
				return false;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (board[i][column] == board[row][column] && i != row) {
				return false;
			}
		}

		int areaRow = row / 3;
		int areaColumn = column / 3;
		for (int i = areaRow * 3; i < areaRow * 3 + 3; i++) {
			for (int j = areaColumn * 3; j < areaColumn * 3 + 3; j++) {
				if (board[i][j] == board[row][column]
						&& !(i == row && j == column)) {
					return false;
				}
			}
		}

		return true;
	}

	public boolean assistant(char[][] board, int x, int y) {
		if (x == 9)
			return true;
		if (y == 9)
			return assistant(board, x + 1, 0);

		if (board[x][y] == '.') {
			for (int i = 1; i <= 9; i++) {
				board[x][y] = Integer.toString(i).charAt(0);
				if (isValidNewNumber(board, x, y)) {
					if (assistant(board, x, y + 1))
						return true;
				}
			}
			// recover failed attempts
			board[x][y] = '.';
		} else {
			return assistant(board, x, y + 1);
		}

		return false;

	}

	public void solveSudoku(char[][] board) {

		assistant(board, 0, 0);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
