public class MaxGap {

	public static int maximumGap(int[] num) {
		if (num == null || num.length < 2)
			return 0;

		if (num.length == 2)
			return Math.abs(num[0] - num[1]);

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < num.length; i++) {
			max = Math.max(max, num[i]);
			min = Math.min(min, num[i]);
		}

		double interval = (double) (max - min) / (double) (num.length - 1);

		int[] minIntervalArray = new int[num.length - 1];
		int[] maxIntervalArray = new int[num.length - 1];
		boolean[] intervalFilledArray = new boolean[num.length - 1];

		for (int i = 0; i < num.length - 1; i++) {
			minIntervalArray[i] = Integer.MAX_VALUE;
			maxIntervalArray[i] = Integer.MIN_VALUE;
			intervalFilledArray[i] = false;
		}
		int currentIndex;
		for (int i = 0; i < num.length; i++) {
			
			if(num[i] == max)
			{
				intervalFilledArray[ num.length - 2]= true;
				minIntervalArray[num.length - 2] = Math.min(
						minIntervalArray[num.length - 2], num[i]);
				maxIntervalArray[num.length - 2] = Math.max(
						maxIntervalArray[num.length - 2], num[i]);
				
			}
			
			else
			{
				currentIndex = (int) ((double) (num[i] - min) / interval);
				if (!intervalFilledArray[currentIndex])
					intervalFilledArray[currentIndex] = true;
				minIntervalArray[currentIndex] = Math.min(
						minIntervalArray[currentIndex], num[i]);
				maxIntervalArray[currentIndex] = Math.max(
						maxIntervalArray[currentIndex], num[i]);

			}
			
			
		}

		int result = 0;
		int currentLowerBound = maxIntervalArray[0];
		for (int i = 1; i < num.length - 1; i++) {
			if (intervalFilledArray[i]) {
				result = Math.max(result, minIntervalArray[i]
						- currentLowerBound);
				currentLowerBound = maxIntervalArray[i];
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 9, 8, -2 };

		System.out.println(maximumGap(array));

	}

}
