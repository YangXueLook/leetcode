
public class SquareCombination {
	public static int findMinCombination(int n)
	{
		int maxRequiredNumber = (int) Math.ceil(Math.sqrt(n));
		
//		System.out.println(maxRequiredNumber);
		
		int[][] matrix = new int[maxRequiredNumber + 1][n + 1];
		
		for(int i = 0; i < matrix[0].length; i++)
			matrix[0][i] = 0;
		
//		System.out.println(matrix[0].length);
		
		for(int i = 0; i < matrix.length; i++)
			matrix[i][0] = 0;
		
		for(int i = 1; i < matrix[0].length; i++)
			matrix[1][i] = i;
		
		for(int i = 2; i < matrix.length; i++)
		{
			for(int j = 1; j < matrix[0].length; j++)
			{
				if(j >= i * i)
				{
					matrix[i][j] = Math.min(matrix[i][j - i * i] + 1, matrix[i - 1][j]);
				}
				else
				{
					matrix[i][j] = matrix[i - 1][j];
				}
				
			}
		}
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				System.out.print(matrix[i][j]+ "\t");
			}
			System.out.println();
		}
		
		
		return matrix[maxRequiredNumber][n];
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMinCombination(2));
	}

}
