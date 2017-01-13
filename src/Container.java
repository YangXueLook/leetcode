public class Container {

	public int maxArea(int[] height) {
		int result = 0;

		int low = 0;
		int high = height.length - 1;

		while (low < high) {
			result = Math.max(result,
					(high - low) * Math.min(height[low], height[high]));
			if (height[low] < height[high]) {
				low++;
			} else {
				high--;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
