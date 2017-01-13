import java.util.Scanner;


public class FootPrint {
	
//	public static char[][] M;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		scan.nextLine();
		char[][] matrix = new char[n][m];
		
		for(int i = 0; i < n; i++)
			matrix[i] = scan.nextLine().toCharArray();
		
//		M = new char[n][m];
//		for(int i = 0; i < n; i++)
//			for(int j = 0; j < m; j++)
//				M[i][j] = 'v';
		
		System.out.println(helper(matrix));
		
//		System.out.println("----------");
//		for(int i = 0; i < n; i++)
//		{
//			System.out.println();
//			for(int j = 0; j < m; j++)
//				System.out.print(M[i][j] + "\t");
//		}
			

	}

	private static int helper(char[][] matrix) {
		// TODO Auto-generated method stub
		int minPossibleAge = Integer.MAX_VALUE;
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix.length; j++)
			{
				if(isVertex(matrix, i, j))
				{
					minPossibleAge = Math.min(minPossibleAge, getAge(matrix, i, j));
				}
			}
		}
		
		return minPossibleAge;
	}

	private static int getAge(char[][] matrix, int i, int j) {
		int maxPossibleAge = 1;
		
		int length = 0;
		while(isValidH(matrix, i + length, j, i + length, j + length))
			length++;
		maxPossibleAge = Math.max(maxPossibleAge, length);
		
		length = 0;
		while(isValidH(matrix, i + length, j - length, i + length, j))
			length++;
		maxPossibleAge = Math.max(maxPossibleAge, length);
		
		length = 0;
		while(isValidH(matrix, i - length, j, i - length, j + length))
			length++;
		maxPossibleAge = Math.max(maxPossibleAge, length);
		
		length = 0;
		while(isValidH(matrix, i - length, j - length, i - length, j))
			length++;
		maxPossibleAge = Math.max(maxPossibleAge, length);
		
		
		
		length = 0;
		while(isValidV(matrix, i, j + length, i + length, j + length))
			length++;
		maxPossibleAge = Math.max(maxPossibleAge, length);
		
		length = 0;
		while(isValidV(matrix, i - length, j + length, i, j + length))
			length++;
		maxPossibleAge = Math.max(maxPossibleAge, length);
		
		length = 0;
		while(isValidV(matrix, i, j - length, i + length, j - length))
			length++;
		maxPossibleAge = Math.max(maxPossibleAge, length);
		
		length = 0;
		while(isValidV(matrix, i - length, j - length, i, j - length))
			length++;
		maxPossibleAge = Math.max(maxPossibleAge, length);
		
		
		return maxPossibleAge;
	}

	

	private static boolean isValidV(char[][] matrix, int istart, int jstart, int iend, int jend) {
		if(istart < 0 || istart >= matrix.length || iend < 0 || iend >= matrix.length)
			return false;
		
		if(jstart < 0 || jstart >= matrix[0].length || jend < 0 || jend >= matrix[0].length)
			return false;
		
		for(int i = istart; i <= iend; i++)
			if(matrix[i][jstart] != '#')
				return false;

		
		return true;
	}

	private static boolean isValidH(char[][] matrix, int istart, int jstart, int iend, int jend) {
		if(istart < 0 || istart >= matrix.length || iend < 0 || iend >= matrix.length)
			return false;
		
		if(jstart < 0 || jstart >= matrix[0].length || jend < 0 || jend >= matrix[0].length)
			return false;
		
		for(int i = jstart; i <= jend; i++)
			if(matrix[istart][i] != '#')
				return false;

		
		return true;
	}

	private static boolean isVertex(char[][] matrix, int i, int j) {
		if(matrix[i][j] == '.')
		{
//			M[i][j] = '*';
			return false;
		}
			
		if(i == 0)
		{
			if(i == matrix.length - 1)
				return true;
			if(matrix[i + 1][j] == '.')
				return true;
			
			if((j == 0 || matrix[i][j - 1] == '.')&&(j == matrix[0].length - 1 || matrix[i][j + 1] == '.'))
				return true;
		}
		
		else if(i == matrix.length - 1)
		{
			if(i == 0)
				return true;
			if(matrix[i - 1][j] == '.')
				return true;
			
			if((j == 0 || matrix[i][j - 1] == '.')&&(j == matrix[0].length - 1 || matrix[i][j + 1] == '.'))
				return true;
		}
		
		else if(j == 0)
		{
			if(j == matrix[0].length - 1)
				return true;
			if(matrix[i][j + 1] == '.')
				return true;
			
			if((i == 0 || matrix[i - 1][j] == '.')&&(i == matrix.length - 1 || matrix[i + 1][j] == '.'))
				return true;
		}
		
		else if(j == matrix[0].length - 1)
		{
			if(j == 0)
				return true;
			if(matrix[i][j - 1] == '.')
				return true;
			
			if((i == 0 || matrix[i - 1][j] == '.')&&(i == matrix.length - 1 || matrix[i + 1][j] == '.'))
				return true;
		}
		
		else if(matrix[i - 1][j] == '.' && matrix[i + 1][j] == '.')
			return true;
		
		else if(matrix[i][j - 1] == '.' && matrix[i][j + 1] == '.')
			return true;

		
//		M[i][j] = '*';
		
		return false;
	}

	

}
