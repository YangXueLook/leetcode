import java.util.Arrays;

public class Candy {
	public int candy(int[] ratings) {
		Arrays.sort(ratings);
		int[] sum = new int[ratings.length];
		int currentValue= 0;
		
		for(int i = 0; i < ratings.length; i++)
		{
			if(i == 0)
			{
				sum[i] = 1;
				currentValue = ratings[0];
			}
			else
			{
				if(currentValue == ratings[i])
				{
					sum[i] = sum[i-1];
				}
				
				else
				{
					sum[i] = sum[i-1]+1;
					currentValue = ratings[i];
				}
			}
		}
		int result = 0;
		
		for(int i = 0; i < sum.length; i++)
			result = result + sum[i];

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
