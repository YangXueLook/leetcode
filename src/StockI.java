public class StockI {

	public static int maxProfit(int[] prices) {
		int result = 0;
		if (prices.length <= 1)
			return 0;

		int lowestPrice = prices[0];

		for (int i = 1; i < prices.length; i++) {
			lowestPrice = Math.min(lowestPrice, prices[i]);
			result = Math.max(result, prices[i] - lowestPrice);
		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
