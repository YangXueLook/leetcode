public class RegularExpression {
	
	private boolean helper(String s, String p, int i, int j)
	{
	    if(j==p.length())
	        return i==s.length();
	    
	    if(j==p.length()-1 || p.charAt(j+1)!='*')
	    {
	        if(i==s.length()|| s.charAt(i)!=p.charAt(j) && p.charAt(j)!='.')
	            return false;
	        else
	            return helper(s,p,i+1,j+1);
	    }
	    //p.charAt(j+1)=='*'
	    while(i<s.length() && (p.charAt(j)=='.' || s.charAt(i)==p.charAt(j)))
	    {
	        if(helper(s,p,i,j+2))
	            return true;
	        i++;
	    }
	    return helper(s,p,i,j+2);
	}

	public boolean assitant(String s, String p, int currentSIndex, int currentPIndex)
	{
		if(currentSIndex == s.length() && currentPIndex == p.length())
			return true;
		else if(currentSIndex == s.length() && p.substring(currentPIndex, p.length()).equals("*"))
			return true;
		else if(currentPIndex == p.length()-1 && p.charAt(currentPIndex) == '*')
		{
			char repeatedChar = p.charAt(currentPIndex-1);
			if(repeatedChar == '.')
				return true;
			else
			{
				for(int i = currentSIndex; i< s.length(); i++)
				{
					if(s.charAt(i) != repeatedChar)
						return false;
				}
				return true;
			}
		}
			
		else if(currentSIndex == s.length() || currentPIndex == p.length())
			return false;
		
		if(p.charAt(currentPIndex) == '.')
			return assitant(s,p,currentSIndex+1,currentPIndex+1);
		if(p.charAt(currentPIndex) == s.charAt(currentSIndex))
			return assitant(s,p,currentSIndex+1,currentPIndex+1);
		if(p.charAt(currentPIndex) == '*')
		{
			char repeatedChar = p.charAt(currentPIndex-1);
			if(repeatedChar == '.')
			{
				while(currentSIndex < s.length())
				{
					if(assitant(s,p,currentSIndex,currentPIndex+1))
						return true;
					currentSIndex++;
				}
			}
			else
			{
				for(int i = currentSIndex; i < s.length() &&s.charAt(i) == repeatedChar ; i++)
				{
					if(assitant(s,p,i,currentPIndex+1))
						return true;
				}
			}
			
		}
		
		return false;
	}

	public boolean isMatch(String s, String p) {
		if (s == null || p == null)
			return false;

		return helper(s, p, 0, 0);
	}

	public static void main(String[] args) {
		RegularExpression t = new RegularExpression();
		String s = "aaa";
		String p = "a*";
		System.out.println(t.isMatch(s,p));

	}

}
