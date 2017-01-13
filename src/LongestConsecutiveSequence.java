import java.util.HashMap;

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] num) {
		HashMap<Integer, LowerUpperPairs> valueAndParis = new HashMap<Integer, LowerUpperPairs>();

		int result = 0;

		for (int i = 0; i < num.length; i++) {
			if (valueAndParis.containsKey(num[i]))
				continue;
			int lower = num[i];
			int upper = num[i];

			if (valueAndParis.containsKey(num[i] - 1))
				lower = valueAndParis.get(num[i] - 1).getLower();
			if (valueAndParis.containsKey(num[i] + 1))
				upper = valueAndParis.get(num[i] + 1).getUpper();
			LowerUpperPairs lu = new LowerUpperPairs();
			lu.setLower(lower);
			lu.setUpper(upper);

			valueAndParis.put(num[i], lu);

			LowerUpperPairs lulower = new LowerUpperPairs();
			lulower.setLower(lower);
			lulower.setUpper(upper);

			if (!valueAndParis.containsKey(lower)) {
				valueAndParis.put(lower, lulower);
			} else {
				valueAndParis.remove(lower);
				valueAndParis.put(lower, lulower);
			}

			LowerUpperPairs luupper = new LowerUpperPairs();
			luupper.setLower(lower);
			luupper.setUpper(upper);
			if (!valueAndParis.containsKey(upper)) {
				valueAndParis.put(upper, luupper);
			}

			else {
				valueAndParis.remove(upper);
				valueAndParis.put(upper, luupper);
			}

			result = Math.max(result, upper - lower + 1);

		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class LowerUpperPairs {
	private int lower = 0;
	private int upper = 0;

	public int getLower() {
		return lower;
	}

	public void setLower(int lower) {
		this.lower = lower;
	}

	public int getUpper() {
		return upper;
	}

	public void setUpper(int upper) {
		this.upper = upper;
	}

}