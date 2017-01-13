import java.util.HashSet;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		HashSet<Character> nineNumbers = new HashSet<Character>();

		if (board.length != 9)
			return false;
		for (int i = 0; i < board.length; i++) {
			if (board[i].length != 9)
				return false;
		}

		// condition 1
		for (int i = 0; i < board.length; i++) {
			nineNumbers.clear();
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != '.') {
					if (nineNumbers.contains(board[i][j])) {
						return false;
					} else {
						nineNumbers.add(board[i][j]);
					}
				}
			}

		}

		// condition 2
		for (int i = 0; i < board.length; i++) {
			nineNumbers.clear();
			for (int j = 0; j < board[i].length; j++) {
				if (board[j][i] != '.') {
					if (nineNumbers.contains(board[j][i])) {
						return false;
					} else {
						nineNumbers.add(board[j][i]);
					}
				}
			}

		}
		// condition 3
		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {
				nineNumbers.clear();
				for (int m = 0; m < 3; m++) {
					for (int n = 0; n < 3; n++) {

						if (board[i * 3 + m][j * 3 + n] != '.') {
							if (nineNumbers
									.contains(board[i * 3 + m][j * 3 + n])) {
								return false;
							} else {
								nineNumbers.add(board[i * 3 + m][j * 3 + n]);
							}
						}

					}
				}

			}

		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
