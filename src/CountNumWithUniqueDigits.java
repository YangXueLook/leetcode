public class CountNumWithUniqueDigits {

	public int countNumbersWithUniqueDigits(int n) {
		int sum = 0;
		for (int i = 1; i <= Math.min(n, 11); i++) {
			sum = sum + helper(i);
		}
		return sum;
	}

	private int helper(int i) {
		
		switch (i)
		{
			case 1:
				return 10;
			case 2:
				return 81;
			case 3:
				return 9 * 9 * 8;
			case 4:
				return 9 * 9 * 8 * 7;
			case 5:
				return 9 * 9 * 8 * 7 * 6;
			case 6:
				return 9 * 9 * 8 * 7 * 6 * 5;
			case 7:
				return 9 * 9 * 8 * 7 * 6 * 5 * 4;
			case 8:
				return 9 * 9 * 8 * 7 * 6 * 5 * 4 * 3;
			case 9:
				return 9 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2;
			case 10:
				return 9 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1;
			default:
				return -1;
		}
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
