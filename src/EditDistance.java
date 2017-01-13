public class EditDistance {

	public static int minDistance(String word1, String word2) {
		if (word1.length() == 0)
			return word2.length();
		else if (word2.length() == 0)
			return word1.length();
		int m = word1.length();
		int n = word2.length();
		int[][] result = new int[m][n];
		result[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
		
		boolean matchedBefore = false;
		for(int i = 1; i < m; i++)
		{
			if(word1.charAt(i) == word2.charAt(0) && !matchedBefore)
			{
				result[i][0] = result[i-1][0];
				matchedBefore = true;
			}
				
			else
				result[i][0] = result[i-1][0]+1;
		}
		
		matchedBefore = false;
		for(int i = 1; i < n; i++)
		{
			if(word1.charAt(0) == word2.charAt(i)&& !matchedBefore)
			{
				result[0][i] = result[0][i-1];
				matchedBefore = true;
			}
				
			else
				result[0][i] = result[0][i-1]+1;
		}
		
		for(int i = 1; i < m; i++)
		{
			for(int j = 1; j  < n; j++)
			{
				if(word1.charAt(i) == word2.charAt(j))
					result[i][j] = result[i-1][j-1];
				else
				{
					result[i][j] = Math.min(result[i-1][j-1], Math.min(result[i-1][j], result[i][j-1])) + 1;
				}
			}
		}
		

		return result[m-1][n-1];
	}

	public static void main(String[] args) {
		String s1 = "pneumonoultramicroscopicsilicovolcanoconiosis";
		String s2 = "ultramicroscopically";
		System.out.println(minDistance(s1, s2));

	}

}
