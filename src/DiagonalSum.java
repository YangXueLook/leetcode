
public class DiagonalSum {
	
	public static int[] diagonal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[rows + cols - 1];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j - i + (rows - 1)] =result[j - i + (rows - 1)] +  matrix[i][j];
            }
        }
        return result;
    }

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,2,3},{4,5,6}};
		int[] result = diagonal(matrix);
		for(int num: result)
			System.out.println(num);
	}

}
