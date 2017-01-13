public class ShortestPalindrome {
	private boolean isPal(String s)
	{
		for(int i = 0; i < s.length()/2; i++)
		{
			if(s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}
		
		return true;
	}
	
	
	public String shortestPalindrome(String s) {
		int palSubstringlength = s.length();
		for(int i = s.length(); i >= 1; i--)
		{
			if(isPal(s.substring(0, i)))
				break;
			else
			{
				palSubstringlength--;
			}
		}
		
		if(palSubstringlength == s.length())
			return s;
		
		String add = new StringBuffer(s.substring(palSubstringlength, s.length())).reverse().toString();
		

		return add + s;
	}

	public static void main(String[] args) {
		ShortestPalindrome t = new ShortestPalindrome();
		System.out.println(t.isPal("ab"));
		
		System.out.println(t.shortestPalindrome("aacecaaa"));
		System.out.println(t.shortestPalindrome("abcd"));

	}

}
