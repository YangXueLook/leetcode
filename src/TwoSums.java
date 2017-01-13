public abstract class TwoSums {

	public static int[] twoSum(int[] numbers, int target) {

		int[] result = new int[2];
		boolean stopFlag = false;
		for (int i = 0; i < numbers.length && !stopFlag; i++) {
			int left = target - numbers[i];
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] == left) {
					result[0] = i + 1;
					result[1] = j + 1;
					stopFlag = true;
					break;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int a[] = new int[] { 2, 7, 11, 15 };
		int b[] = twoSum(a, 9);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]);
		}

	}

}
