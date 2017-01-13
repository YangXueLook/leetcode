public class MaxSquare {
	private class cell
	{
		int x = 0;
		int y = 0;
		cell(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}

	public int maximalSquare(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		
		int[][] resultMatrix = new int[matrix.length][matrix[0].length];
		
		int result = 0;
		for(int i = 0; i < matrix.length; i++)
		{
			if(matrix[i][0] == '1')
			{
				resultMatrix[i][0] = 1;
				result = 1;
			}
				
			else
				resultMatrix[i][0] = 0;
		}
		
		for(int i = 0; i < matrix[0].length; i++)
		{
			if(matrix[0][i] == '1')
			{
				resultMatrix[0][i] = 1;
				result = 1;
			}
				
			else
				resultMatrix[0][i] = 0;
		}
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				if(matrix[i][j] == '1')
				{
					resultMatrix[i][j] = 1 + Math.min(resultMatrix[i - 1][j - 1], Math.min(resultMatrix[i][j - 1], resultMatrix[i - 1][j]));
					result = Math.max(result, resultMatrix[i][j]*resultMatrix[i][j]);
				}
				else
					resultMatrix[i][j] = 0;
			}
		}
		

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
