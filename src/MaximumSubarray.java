public class MaximumSubarray {

	public int maxSubArray(int[] A) {
		int result = Integer.MIN_VALUE;
		int current = Integer.MIN_VALUE;;

		for (int i = 0; i < A.length; i++)
		{
			if(current < 0)
				current = A[i];
			else
			{
				current = current + A[i];
			}
			if(current > result)
				result = current;
		}

			return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
