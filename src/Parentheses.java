public class Parentheses {

	public static int longestValidParentheses(String s) {
		// if (s == null)
		// return 0;
		//
		// if (s.length() == 0 || s.length() == 1)
		// return 0;
		//
		// int max = 0;
		// int currentLength = 0;
		// boolean searchingForLeft = true;
		//
		// for (int i = 0; i < s.length(); i++) {
		// char c = s.charAt(i);
		// if (i == s.length() - 1) {
		// if (searchingForLeft) {
		// if (currentLength > max) {
		// max = currentLength;
		// }
		// } else {
		// if (c == ')') {
		// currentLength++;
		// }
		// if (currentLength > max) {
		// max = currentLength;
		// }
		// }
		// }
		//
		// if (searchingForLeft) {
		// if (c == '(') {
		// searchingForLeft = false;
		// } else {
		// searchingForLeft = true;
		// if (currentLength > max) {
		// max = currentLength;
		// }
		// currentLength = 0;
		// }
		// } else {
		// if (c == '(') {
		// searchingForLeft = false;
		// if (currentLength > max) {
		// max = currentLength;
		// }
		// currentLength = 0;
		// } else {
		// currentLength++;
		// searchingForLeft = true;
		// }
		// }
		//
		// }
		//
		// return max * 2;

		if (s == null)
			return 0;

		if (s.length() == 0 || s.length() == 1)
			return 0;
		
		char[] charArray = s.toCharArray();
		
		for(int i = 0; i <charArray.length; i++)
		{
			if(charArray[i] == ')')
			{
				for (int j = i-1; j>=0; j--)
				{
					if(charArray[j] == '(')
					{
						charArray[i] = '0';
						charArray[j] = '0';
						break;
					}
				}
			}
		}
		
		int max = 0;
		int current = 0;
		
		for (int i = 0; i < charArray.length; i++)
		{
			if(i ==charArray.length-1 )
			{
				if(charArray[i] == '0')
				{
					current++;
				}
				max = Math.max(max, current);
			}
			
			if(charArray[i] == '0')
			{
				current++;
			}
			else
			{
				max = Math.max(max, current);
				current = 0;
			}
		}
		
		
		return max;

	}

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("(()))()())"));

	}

}
