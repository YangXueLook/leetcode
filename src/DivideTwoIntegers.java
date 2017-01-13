public class DivideTwoIntegers {

	public static int divide(int dividend, int divisor) {
		if(divisor == 0)
			return Integer.MAX_VALUE;
		int result = 0;
		
		if(dividend == Integer.MIN_VALUE)
		{
			if(divisor == -1)
				return Integer.MAX_VALUE;
			dividend = dividend + Math.abs(divisor);
			result++;
		}
		if(divisor == Integer.MIN_VALUE)
		{
			return result;
		}
		
		boolean isNegative = (divisor<0&& dividend>0)||(divisor > 0&& dividend < 0);
		
		
		
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		
		int halfDividend = dividend>>1;

		

		
		int offset = 0;
		while(halfDividend >= divisor )
		{
			divisor = divisor<<1;
			offset++;
		}
		
		

		
		for(int i = offset; i >= 0; i--)
		{
			
			if(dividend > divisor)
			{
				result = result + (int)Math.pow(2, i);
				dividend = dividend - divisor;
			}
			else if(dividend == divisor)
			{
				result = result + (int)Math.pow(2, i);
				break;
			}
			divisor = divisor>>1;
		}

		return isNegative ? -result: result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println((Integer.MAX_VALUE/2)<<2);
		System.out.println(divide(75,2));

	}

}
