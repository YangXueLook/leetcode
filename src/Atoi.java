public class Atoi {

	public static int atoi(String str) {
		if(str == null)
			return 0;
		str = str.trim();
		if(str.length() == 0)
			return 0;
		char[] charArray = str.toCharArray();
		int startIndex = 0;
		boolean isNegative = false;
		int result = 0;
		if(charArray[0] == '-')
		{
			startIndex++;
			isNegative = true;
		}
		else if(charArray[0] == '+')
			startIndex++;
		
		for(int i = startIndex; i < str.length(); i++)
		{
			if(charArray[i] > '9' || charArray[i] < '0')
				break;
			if(!isNegative && result > (Integer.MAX_VALUE -(charArray[i] - '0')) /10)
				return Integer.MAX_VALUE;
			if(isNegative && result > -((Integer.MIN_VALUE + (charArray[i] - '0'))/10))
				return Integer.MIN_VALUE;
			result = result*10 + (charArray[i] - '0');
			
		}
		

		return isNegative? -result: result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(atoi("-1"));
	}

}
