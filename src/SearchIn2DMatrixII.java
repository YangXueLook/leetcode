public class SearchIn2DMatrixII {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		
		
		int r = 0;
		int c =  matrix[0].length - 1;
		
		while(r < matrix.length && c >= 0)
		{
			if(matrix[r][c] == target)
				return true;
			else if (matrix[r][c] > target)
				c--;
			else
				r++;
		}
		
		
		
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,   4,  7, 11, 15},
				  {2,   5,  8, 12, 19},
				  {3,   6,  9, 16, 22},
				  {10, 13, 14, 17, 24},
				  {18, 21, 23, 26, 30}};
		
//		int[][] matrix = new int[][]{{1, 4}, {2, 5}};
		
//		System.out.println(searchMatrix(matrix, 5));
		System.out.println(searchMatrix(matrix, 12));

	}

}