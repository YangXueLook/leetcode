import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelop {
	public static int maxEnvelopes(int[][] envelopes) {
		if(envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length == 0)
			return 0;
		
		Arrays.sort(envelopes, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}});
		
		for(int[] e: envelopes)
			System.out.println(e[0] + "\t" + e[1]);
		
		int[] resultArray = new int[envelopes.length];
		
		for(int i = 0; i < resultArray.length; i++)
		{
			resultArray[i] = 1;
		}
		
		int max = 1;
		
		for(int i = 1; i < resultArray.length; i++)
		{
			for(int j = i - 1; j >= 0; j--)
			{
				if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
				{
					resultArray[i] = Math.max(resultArray[i], resultArray[j] + 1);
					
				}
				
			}
			max = Math.max(max, resultArray[i]);
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] env = new int[][]{{7,8},{12,16},{12,5},{1,8},{4,19},{3,15},{4,10},{9,16}};
		maxEnvelopes(env);
		

	}

}
