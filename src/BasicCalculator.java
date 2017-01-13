import java.util.Stack;

public class BasicCalculator {
	public static int calculate(String s) {
		s = s.replaceAll(" ", "");
		StringBuffer sb = new StringBuffer(s);
		int currentValue = 0;
		int currentSum = 0;
		Stack<Integer> leftParenthesesIndexStack = new Stack<Integer>();
		for(int i = 0; i < sb.length(); i++)
		{
			if(sb.charAt(i) == '(')
				leftParenthesesIndexStack.push(i);
			else if (sb.charAt(i) == ')')
			{
				int startIndex = leftParenthesesIndexStack.pop();
				if(startIndex == 0)
				{
					sb.setCharAt(startIndex, ' ');
					sb.setCharAt(i, ' ');
				}
				else
				{
					int k = startIndex - 1;
					while(sb.charAt(k) != '+' && sb.charAt(k) != '-')
						k--;
					
					
					if(sb.charAt(k) == '-')
					{
						for(int j = startIndex; j <= i; j++)
						{
							if(sb.charAt(j) == '+')
								sb.setCharAt(j, '-');
							else if(sb.charAt(j) == '-')
								sb.setCharAt(j, '+');
						}
					}
					sb.setCharAt(startIndex, ' ');
					sb.setCharAt(i, ' ');
				}
				
			}
		}
		
		
		
		
//		System.out.println(sb);
		
		s = sb.toString();
		s = s.replaceAll(" ", "");
		int currentSignal = 1;
		
		for(int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if(c == '-')
				currentSignal = 0;
			else if(c == '+')
				currentSignal = 1;
			else
			{
				currentValue = currentValue * 10 + c - '0';
				if(i == s.length() - 1)
				{
					if(currentSignal == 0)
						currentSum = currentSum - currentValue;
					else
						currentSum = currentSum + currentValue;
				}
				else
				{
					if(s.charAt(i+1) != '+' && s.charAt(i+1) != '-')
						continue;
					else
					{
						if(currentSignal == 0)
							currentSum = currentSum - currentValue;
						else
							currentSum = currentSum + currentValue;
						
						currentValue = 0;
					}
				}
			}
		}
		
		
		return currentSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calculate(" 2-1 - (12-6) "));

	}

}
