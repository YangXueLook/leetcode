public class TrappingRainWater {
	public static int trap(int[] A) {
		if (A.length == 0 || A.length == 1 || A.length == 2)
			return 0;

		int result = 0;

		int[] leftHeightArray = new int[A.length];
		int[] rightHeightArray = new int[A.length];

		leftHeightArray[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] <= A[i - 1])
				leftHeightArray[i] = leftHeightArray[i - 1];
			else {
				if (A[i] <= leftHeightArray[i - 1])
					leftHeightArray[i] = leftHeightArray[i - 1];
				else
					leftHeightArray[i] = A[i];

			}
		}

		rightHeightArray[A.length - 1] = A[A.length - 1];
		for (int i = A.length - 2; i >= 0; i--) {
			if (A[i] <= A[i + 1])
				rightHeightArray[i] = rightHeightArray[i + 1];
			else {
				if (A[i] <= rightHeightArray[i + 1])
					rightHeightArray[i] = rightHeightArray[i + 1];
				else
					rightHeightArray[i] = A[i];

			}
		}

		for (int i = 0; i < A.length; i++) {
			result = result + Math.min(leftHeightArray[i], rightHeightArray[i])
					- A[i];
		}

		return result;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(a));
	}

}
