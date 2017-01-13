public class StockII {
	public static int maxProfit(int[] prices) {
		int result = 0;
		if (prices.length <= 1)
			return 0;

		Boolean[] peakPositions = new Boolean[prices.length];
		Boolean[] bottomPositions = new Boolean[prices.length];

		for (int i = 0; i < prices.length; i++) {
			peakPositions[i] = false;
			bottomPositions[i] = false;
		}

		for (int i = 0; i < prices.length; i++) {
			if (i == 0) {
				if (prices[0] < prices[1]) {
					bottomPositions[0] = true;
				}
				if (prices[0] > prices[1]) {
					peakPositions[0] = true;
				}
			} else if (i == prices.length - 1) {
				if (prices[i] < prices[i - 1]) {
					bottomPositions[i] = true;
				}
				if (prices[i] > prices[i - 1]) {
					peakPositions[i] = true;
				}
			} else {
				if ((prices[i] < prices[i - 1] && prices[i] < prices[i + 1])
						|| (prices[i] <= prices[i - 1] && prices[i] < prices[i + 1])
						|| (prices[i] < prices[i - 1] && prices[i] <= prices[i + 1])) {
					bottomPositions[i] = true;
				}
				if ((prices[i] > prices[i - 1] && prices[i] > prices[i + 1])
						|| (prices[i] >= prices[i - 1] && prices[i] > prices[i + 1])
						|| (prices[i] > prices[i - 1] && prices[i] >= prices[i + 1])) {
					peakPositions[i] = true;
				}
			}

		}
		int firstBottomIndex = -1;
		for (int i = 0; i < bottomPositions.length; i++) {
			if (bottomPositions[i] == true) {
				firstBottomIndex = i;
				break;
			}
		}

		int lastPeakIndex = peakPositions.length;
		for (int i = peakPositions.length - 1; i > 0; i--) {
			if (peakPositions[i] == true) {
				lastPeakIndex = i;
				break;
			}
		}

		System.out.println("firstBottomIndex: " + firstBottomIndex
				+ " lastPeakIndex: " + lastPeakIndex);
		if (firstBottomIndex > lastPeakIndex || firstBottomIndex == -1
				|| lastPeakIndex == peakPositions.length)
			return 0;

		boolean stop = false;
		int currentLowestValue = prices[firstBottomIndex];
		for (int i = firstBottomIndex; i < bottomPositions.length && !stop;) {

			if (bottomPositions[i] == true) {
				boolean foundMatchedPeak = false;
				currentLowestValue = prices[i];
				for (int j = i; j < peakPositions.length; j++) {

					if (peakPositions[j] == true) {
						result = result + prices[j] - currentLowestValue;
						i = j + 1;
						foundMatchedPeak = true;
						break;
					}
				}

				if (foundMatchedPeak == false) {
					stop = true;
				}
			}

		}

		return result;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 7, 4, 2 };

		System.out.println(maxProfit(a));
	}

}
