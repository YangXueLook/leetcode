public class CoinChange {

	public static int coinChange(int[] coins, int amount) {
		if(coins == null || coins.length == 0)
			return -1;
		if(amount == 0)
			return 0;
		
		int[][] result = new int[amount + 1][coins.length];
		
		for(int i = 0; i < amount + 1; i++)
		{
			for(int j = 0; j < coins.length; j++)
			{
				result[i][j] = -1;
					
			}
		}
		
		
		for(int i = 1; i < amount + 1; i++)
		{
			for(int j = 0; j < coins.length; j++)
			{
				if(coins[j] == i)
					result[i][j] = 1;
				if(coins[j] > i)
				{
					if(j == 0)
						result[i][j] = -1;
					else
						result[i][j] = result[i][j - 1];
				}
					
				
				if(coins[j] < i)
				{
					if(j == 0)
					{
						if(result[i - coins[j]][j] == - 1)
							result[i][j] = -1;
						else
							result[i][j] = result[i - coins[j]][j] + 1;
					}
					else
					{
						if(result[i - coins[j]][j] == - 1 && result[i][j - 1] == -1)
							result[i][j] = -1;
						else if(result[i - coins[j]][j] == - 1)
							result[i][j] = result[i][j - 1];
						else if(result[i][j - 1] == -1)
							result[i][j] = result[i - coins[j]][j] + 1;
						else	
							result[i][j] = Math.min(result[i][j - 1], result[i - coins[j]][j] + 1);
					}
					
					
				}
					
					
			}
		}
		

		return result[amount][coins.length - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(coinChange(new int[]{2}, 3));

	}

}
