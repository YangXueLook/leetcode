import java.util.Arrays;


public class LongestRepeatingSubString {
	public static String getLongestRepeatingSubString(String s)
	{
		String[] surfixStringArray = new String[s.length()];
		for(int i = 0; i < s.length(); i++)
		{
			surfixStringArray[i] = s.substring(i, s.length());
		}
		
		Arrays.sort(surfixStringArray);
		
		for(String str: surfixStringArray)
			System.out.println(str);
//		
		String result = "";
		
		for(int i = 0; i < surfixStringArray.length - 1; i++)
		{
			String currentMaxCommonPrefix = getMaxPrefix(surfixStringArray[i], surfixStringArray[i + 1]);
			result = result.length() > currentMaxCommonPrefix.length() ? result : currentMaxCommonPrefix;
		}
		
		
		return result;
	}
	

	private static String getMaxPrefix(String s1, String s2) {
		int index = 0;
		for(index = 0; index < Math.min(s1.length(), s2.length()); index++)
		{
			if(s1.charAt(index) != s2.charAt(index))
				break;
		}

		
		return s1.substring(0, index);
	}


	public static void main(String[] args) {
//		System.out.println(getMaxPrefix("anana","banan"));
		
		
		// TODO Auto-generated method stub
		System.out.println(getLongestRepeatingSubString("ababab"));
	}

}
