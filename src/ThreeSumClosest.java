import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);

		int result = num[0] + num[1] + num[2];
		int currentSum = 0;

		for (int i = 0; i < num.length - 2; i++) {
			int forwardIndex = i + 1;
			int backwardIndex = num.length - 1;
			while (forwardIndex < backwardIndex) {
				currentSum = num[i] + num[forwardIndex] + num[backwardIndex];
				if (Math.abs(currentSum - target) < Math.abs(result - target)) {
					result = currentSum;
					if (currentSum == target)
						return currentSum;
				}

				if (currentSum > target) {
					backwardIndex--;
				} else {
					forwardIndex++;
				}
			}

		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
