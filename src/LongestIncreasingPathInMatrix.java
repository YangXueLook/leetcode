public class LongestIncreasingPathInMatrix {

	public int longestIncreasingPath(int[][] matrix) {
		if(matrix == null || matrix.length ==0 || matrix[0].length == 0)
			return 0;
		
		int result = 1;
		
		int[][] resultMatrix = new int[matrix.length][matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				int length = dfs(matrix, i, j, resultMatrix);
				resultMatrix[i][j] = length;
				
				result = Math.max(result, length);
			}
		}
		
		

		return result;
	}

	private int dfs(int[][] matrix, int i, int j, int[][] resultMatrix) {
		// TODO Auto-generated method stub
		
		if(resultMatrix[i][j] != 0)
			return resultMatrix[i][j];
		
		int result = 1;
		
		if(i != 0 && resultMatrix[i][j] < resultMatrix[i + 1][j])
			result = Math.max(result, dfs(matrix, i + 1, j, resultMatrix) + 1);
		
		if(i != resultMatrix.length - 1 && resultMatrix[i][j] < resultMatrix[i - 1][j])
			result = Math.max(result, dfs(matrix, i - 1, j, resultMatrix) + 1);
		
		if(j != 0 && resultMatrix[i][j] < resultMatrix[i][j + 1])
			result = Math.max(result, dfs(matrix, i, j + 1, resultMatrix) + 1);
		
		if(j != resultMatrix[0].length - 1 && resultMatrix[i][j] < resultMatrix[i][j - 1])
			result = Math.max(result, dfs(matrix, i, j - 1, resultMatrix) + 1);
		
		
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
