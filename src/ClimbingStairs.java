public final class ClimbingStairs {

	public int climbStairs(int n) {

		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else if (n == 2)
			return 2;
		else {
			int result[] = new int[n];
			result[0] = 1;
			result[1] = 2;
			for (int i = 2; i < result.length; i++)
				result[i] = result[i - 1] + result[i - 2];

			return result[n - 1];
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
