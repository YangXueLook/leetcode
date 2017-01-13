public class Search2DMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int low = 0;
		int high = matrix.length - 1;
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (target == matrix[mid][0])
				return true;
			else if (target < matrix[mid][0])
				high = mid - 1;
			else
				low = mid + 1;
		}
		int row = (low + high) / 2;
		low = 0;
		high = matrix[0].length - 1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (target == matrix[row][mid])
				return true;
			else if (target < matrix[row][mid])
				high = mid - 1;
			else
				low = mid + 1;
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
				{ 23, 30, 34, 50 } };
		System.out.println(searchMatrix(matrix,8));

	}

}
