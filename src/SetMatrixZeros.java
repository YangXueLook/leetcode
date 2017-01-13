public class SetMatrixZeros {

	public void setZeroes(int[][] matrix) {
		if (matrix.length == 0)
			return;
		if (matrix[0].length == 0)
			return;
		boolean setFirstRowToZero = false;
		boolean setFirstColumnToZero = false;
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				setFirstRowToZero = true;
				break;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				setFirstColumnToZero = true;
				break;
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

//		for (int j = 0; j < matrix[0].length; j++) {
//			if (matrix[0][j] == 0) {
//				for (int i = 0; i < matrix.length; i++) {
//					matrix[i][j] = 0;
//				}
//			}
//		}
//
//		for (int i = 0; i < matrix.length; i++) {
//			if (matrix[i][0] == 0) {
//				for (int j = 0; j < matrix[0].length; j++) {
//					matrix[i][j] = 0;
//				}
//			}
//		}
		
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++)
			{
				if(matrix[i][0] == 0||matrix[0][j] == 0)
					matrix[i][j] = 0;
			}
		}
		
		
		if (setFirstRowToZero) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}

		if (setFirstColumnToZero) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
