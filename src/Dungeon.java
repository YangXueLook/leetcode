public class Dungeon {
	public static int calculateMinimumHP(int[][] dungeon) {
		
		if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
			return 1;
		
		int m  = dungeon.length;
		int n = dungeon[0].length;
		
		int[][] resultMatrix = new int[m][n];
		resultMatrix[m-1][n-1] = dungeon[m-1][n-1] >= 0 ? 0 : Math.abs(dungeon[m-1][n-1]);
		
		for(int i = m-2; i >=0; i--)
		{
			resultMatrix[i][n-1] = Math.max(0, resultMatrix[i+1][n-1] - dungeon[i][n-1]);
		}
		
		for(int i = n-2; i >=0; i--)
		{
			resultMatrix[m-1][i] = Math.max(0, resultMatrix[m-1][i+1] - dungeon[m-1][i]);
		}
		
		for(int i = m-2; i >=0; i--)
		{
			for(int j = n-2; j >= 0; j--)
			{
				resultMatrix[i][j] = Math.max(0, Math.min(resultMatrix[i][j+1] - dungeon[i][j], resultMatrix[i+1][j] - dungeon[i][j]));
			}
		}
		
		
		return resultMatrix[0][0]+1;
//		requestAndLeftHPPair[][] resultMatrix = new requestAndLeftHPPair[dungeon.length][dungeon[0].length];
//		if(dungeon[0][0] >= 0)
//			resultMatrix[0][0] = new requestAndLeftHPPair(0,0);
//		else
//			resultMatrix[0][0] = new requestAndLeftHPPair(-dungeon[0][0],0);
//		for(int i = 1; i < dungeon.length; i++)
//		{
//			if(dungeon[i][0] >= 0)
//			{
//				resultMatrix[i][0] = new requestAndLeftHPPair(resultMatrix[i-1][0].minRequestHP,resultMatrix[i-1][0].currentLeftHP+dungeon[i][0]);
//			}
//			else
//			{
//				if(resultMatrix[i-1][0].currentLeftHP+dungeon[i][0] >= 0)
//					resultMatrix[i][0] = new requestAndLeftHPPair(resultMatrix[i-1][0].minRequestHP,resultMatrix[i-1][0].currentLeftHP+dungeon[i][0]);
//				else
//					resultMatrix[i][0] = new requestAndLeftHPPair(resultMatrix[i-1][0].minRequestHP - (resultMatrix[i-1][0].currentLeftHP+dungeon[i][0]),0);
//					
//			}
//		}
//		
//		for(int i = 1; i < dungeon[0].length; i++)
//		{
//			if(dungeon[0][i] >= 0)
//			{
//				resultMatrix[0][i] = new requestAndLeftHPPair(resultMatrix[0][i-1].minRequestHP,resultMatrix[0][i-1].currentLeftHP+dungeon[0][i-1]);
//			}
//			else
//			{
//				if(resultMatrix[0][i-1].currentLeftHP+dungeon[0][i] >= 0)
//					resultMatrix[0][i] = new requestAndLeftHPPair(resultMatrix[0][i-1].minRequestHP,resultMatrix[0][i-1].currentLeftHP+dungeon[0][i-1]);
//				else
//					resultMatrix[0][i] = new requestAndLeftHPPair(resultMatrix[0][i-1].minRequestHP - (resultMatrix[0][i-1].currentLeftHP+dungeon[i][0]),0);
//					
//			}
//		}
//		
//		for(int i = 1; i< dungeon.length; i++)
//		{
//			for(int j = 1; j < dungeon[0].length; j++)
//			{
//				
//			}
//		}
		
		
		
	}
	
	class requestAndLeftHPPair
	{
		int minRequestHP = 0;
		int currentLeftHP = 0;
		requestAndLeftHPPair(int minRequestHP, int currentLeftHP)
		{
			this.minRequestHP = minRequestHP;
			this.currentLeftHP = currentLeftHP;
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[][] = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
		System.out.print(calculateMinimumHP(a));
	}

}
