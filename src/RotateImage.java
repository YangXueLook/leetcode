public class RotateImage {
	public static void rotate(int[][] matrix) {
		if (matrix.length == 1)
			return;

		// top to bottom
		int temp = 0;
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[matrix.length - 1 - i][j];
				matrix[matrix.length - 1 - i][j] = temp;
			}
		}
		// flip around diagonal
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[0].length; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + "\t");

			System.out.println();
		}

		rotate(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + "\t");

			System.out.println();
		}

	}

}
