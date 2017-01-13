public class TrailingZeroes {

	public static int trailingZeroes(int n) {
		
		if(n < 5)
			return 0;
		
		int i = 1;
		int result = 0;
		while(n >= Math.pow(5, i))
		{
			result = result + (int)(n/Math.pow(5, i));
			
			i++;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(trailingZeroes(10));

	}

}
