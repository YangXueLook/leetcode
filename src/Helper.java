import java.util.ArrayList;


public class Helper {
	private static ArrayList<String> getAllCominations(int k)
	{
		ArrayList<String> result = new ArrayList<String>();
		if(k == 1)
		{
			
			for(int i = 0; i < 8; i++)
			{
				result.add(String.valueOf((char)('a' + i)));
			}
			return result;
		}
		else
		{
			ArrayList<String> temp = getAllCominations(k - 1);
			for(String s : temp)
			{
				for(int i = 0; i < 8; i++)
				{
					result.add(s + String.valueOf((char)('a' + i)));
				}
			}
			return result;
		}
	}
	
	private static int[] getKGramFre(String s, int k)
	{
//		ArrayList<String> termList = getAllCominations(k);
		int[] result = new int[(int) Math.pow(8, k)];
		for(int i = 0; i < s.length() - k + 1; i++)
		{
			int index = getIndex(s, i, k);
			result[index]++;
		}
		return result;
	}
	
	

	private static int getIndex(String s, int start, int k) {
		int index = 0;
		for(int i = start; i < start + k; i++)
		{
			index = index * 8 + s.charAt(i) - 'a';		 
		}

		return index;
	}

	public static void main(String[] args) {
		int[] fre = getKGramFre("hhhhhhhhhhhhhhhh", 3);
		for(int i = 0; i < fre.length; i++)
		{
			if(fre[i] != 0)
			{
				System.out.println(i + "\t" + fre[i]);
			}
		}

	}

}
