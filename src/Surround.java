import java.util.LinkedList;
import java.util.Queue;

public class Surround {

	public void solve(char[][] board) {
		if (board == null || board.length < 3 || board[0].length < 3)
			return;

		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O') {

				BFSColored(board, i, 0);
			}
			if (board[i][board[0].length - 1] == 'O') {

				BFSColored(board, i, board[0].length - 1);
			}
		}

		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == 'O') {

				BFSColored(board, 0, i);
			}
			if (board[board.length - 1][i] == 'O') {

				BFSColored(board, board.length - 1, i);
			}
		}
		
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[0].length; j++)
//				System.out.print(board[i][j]);
//			System.out.println();
//		}
//		System.out.println("-------------------------------");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				if (board[i][j] == 'A')
					board[i][j] = 'O';
			}
		}

	}

	public void BFSColored(char[][] board, int x, int y) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(x);
		queue.add(y);
		board[x][y] = 'A';
		int currentX;
		int currentY;

		while (!queue.isEmpty()) {
			currentX = queue.poll();
			currentY = queue.poll();
			
			if (currentX < board.length - 1
					&& board[currentX + 1][currentY] == 'O') {
				queue.add(currentX + 1);
				queue.add(currentY);
				board[currentX+1][currentY] = 'A';
			}

			if (currentX > 0 && board[currentX - 1][currentY] == 'O') {
				queue.add(currentX - 1);
				queue.add(currentY);
				board[currentX-1][currentY] = 'A';
			}

			if (currentY < board[0].length - 1
					&& board[currentX][currentY + 1] == 'O') {
				queue.add(currentX);
				queue.add(currentY + 1);
				board[currentX][currentY+1] = 'A';
			}

			if (currentY > 0 && board[currentX][currentY - 1] == 'O') {
				queue.add(currentX);
				queue.add(currentY - 1);
				board[currentX][currentY-1] = 'A';
			}

		}
	}

	class Point {
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		int x;
		int y;
	}

	public static void main(String[] args) {
		char[][] board = new char[][] { "XOOOOOOOOOOOOOOOOOOO".toCharArray(),
				"OXOOOOXOOOOOOOOOOOXX".toCharArray(),
				"OOOOOOOOXOOOOOOOOOOX".toCharArray(),
				"OOXOOOOOOOOOOOOOOOXO".toCharArray(),
				"OOOOOXOOOOXOOOOOXOOX".toCharArray(),
				"XOOOXOOOOOXOXOXOXOXO".toCharArray(),
				"OOOOXOOXOOOOOXOOXOOO".toCharArray(),
				"XOOOXXXOXOOOOXXOXOOO".toCharArray(),
				"OOOOOXXXXOOOOXOOXOOO".toCharArray(),
				"XOOOOXOOOOOOXXOOXOOX".toCharArray(),
				"OOOOOOOOOOXOOXOOOXOX".toCharArray(),
				"OOOOXOXOOXXOOOOOXOOO".toCharArray(),
				"XXOOOOOXOOOOOOOOOOOO".toCharArray(),
				"OXOXOOOXOXOOOXOXOXOO".toCharArray(),
				"OOXOOOOOOOXOOOOOXOXO".toCharArray(),
				"XXOOOOOOOOXOXXOOOXOO".toCharArray(),
				"OOXOOOOOOOXOOXOXOXOO".toCharArray(),
				"OOOXOOOOOXXXOOXOOOXO".toCharArray(),
				"OOOOOOOOOOOOOOOOOOOO".toCharArray(),
				"XOOOOXOOOXXOOXOXOXOO".toCharArray() };

		Surround test = new Surround();

		test.solve(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++)
				System.out.print(board[i][j]);
			System.out.println();
		}

	}

}
