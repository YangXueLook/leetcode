import java.util.Arrays;


public class WaterAndTank {
	public static int minTime(int tank, int[] containers)
	{
		Arrays.sort(containers);
		
		int[][] matrix = new int[containers.length][tank + 1];
		
		
		for(int i = 0; i < tank + 1; i++)
			matrix[0][i] = i;
		
		for(int i = 0; i < containers.length; i++)
			matrix[i][0] = 0;
		
		for(int i = 1; i < containers.length; i++)
		{
			for(int j = 1; j < tank + 1; j++)
			{
				if(j >= containers[i])
					matrix[i][j] = Math.min(matrix[i - 1][j], matrix[i][j - containers[i]] + 1);
				else
					matrix[i][j] = matrix[i - 1][j];
			}
		}
		
		return matrix[containers.length - 1][tank];
	}
	

	public static void main(String[] args) {
		System.out.println(minTime(71, new int[]{ 1,3,5,6,25}));

	}

}
