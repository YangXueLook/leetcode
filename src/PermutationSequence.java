import java.util.Arrays;

public class PermutationSequence {

	public int factorial(int n) {
		if (n == 0)
			return 1;

		int result = 1;
		for (int i = 1; i <= n; i++) {
			result = result * i;
		}
		return result;
	}

	public int[] assistant(int n, int k) {
		int[] result = new int[n];

		if (factorial(n) == k) {
			for (int i = 0; i < n; i++) {
				result[i] = n - i;
			}
			return result;
		}

		int orderedSequenceLength = 0;
		int movingIndex = n;
		while (factorial(movingIndex) > k) {
			movingIndex--;
			orderedSequenceLength++;
		}

		if (factorial(movingIndex) == k) {
			for (int i = 0; i < orderedSequenceLength; i++) {
				result[i] = i + 1;
			}
			int[] leftPartResult = assistant(n - orderedSequenceLength, k);

			for (int i = 0; i < leftPartResult.length; i++) {
				result[orderedSequenceLength + i] = leftPartResult[i]
						+ orderedSequenceLength;
			}

			return result;

		} else {
			orderedSequenceLength--;
			for (int i = 0; i < orderedSequenceLength; i++) {
				result[i] = i + 1;
			}

			int tailTimes = k / factorial(movingIndex);
			int left = k % factorial(movingIndex);

			int highestUnsequencedNumber;
			if (left == 0) {
				highestUnsequencedNumber = tailTimes + orderedSequenceLength;
				left = factorial(movingIndex);
			} else
				highestUnsequencedNumber = tailTimes + orderedSequenceLength
						+ 1;

			result[orderedSequenceLength] = highestUnsequencedNumber;

			// System.out.println("call n - orderedSequenceLength - 1 = "
			// + (n - orderedSequenceLength - 1) + "\tleft= " + left
			// + Arrays.toString(result));

			int[] leftPartResult = assistant(n - orderedSequenceLength - 1,
					left);

			// System.out.println(Arrays.toString(leftPartResult)
			// + orderedSequenceLength);

			for (int i = 0; i < leftPartResult.length; i++) {
				result[orderedSequenceLength + i + 1] = leftPartResult[i]
						+ orderedSequenceLength;

				if (result[orderedSequenceLength + i + 1] >= result[orderedSequenceLength])
					result[orderedSequenceLength + i + 1]++;

			}
			return result;

		}

	}

	public String getPermutation(int n, int k) {

		String result = "";

		int[] array = assistant(n, k);

		for (int i = 0; i < array.length; i++) {
			result = result + array[i];
		}

		return result;
	}

	public static void main(String[] args) {
		PermutationSequence t = new PermutationSequence();
		int n = 5;
		int previous = 0;

		String s = "";

		for (int i = 1; i <= t.factorial(n); i++) {
			s = t.getPermutation(n, i);

			if (Integer.parseInt(s) < previous) {
				System.out.println("-----------------");
				break;
			}
			else
			{
				previous = Integer.parseInt(s);
			}

			System.out.println(s);

		}

	}
}
