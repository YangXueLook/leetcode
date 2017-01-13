public class MaximumProductSubarray {

	public int maxProduct(int[] A) {
		if (A.length == 1)
			return A[0];

		int result = 0;
		int maxBeforeCurrent = A[0];
		int minBeforeCurrent = A[0];
		int currentMax = 0;
		int currentMin = 0;

		for (int i = 1; i < A.length; i++) {
			currentMax = Math.max(
					Math.max(A[i] * maxBeforeCurrent, A[i] * minBeforeCurrent),
					A[i]);
			currentMin = Math.min(
					Math.min(A[i] * maxBeforeCurrent, A[i] * minBeforeCurrent),
					A[i]);

			result = Math.max(currentMax, result);

			maxBeforeCurrent = currentMax;
			minBeforeCurrent = currentMin;
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
