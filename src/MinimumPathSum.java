public class MinimumPathSum {

	public int minPathSum(int[][] grid) {
		int[][] result = new int[grid.length][grid[0].length];
		int sum1 = 0;
		for (int i = 0; i < grid.length; i++) {
			result[i][0] = sum1 + grid[i][0];
			sum1 = sum1 + grid[i][0];
		}
		sum1 = 0;
		for (int i = 0; i < grid[0].length; i++) {
			result[0][i] = sum1 + grid[0][i];
			sum1 = sum1 + grid[0][i];
		}

		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				result[i][j] = grid[i][j]
						+ Math.min(result[i - 1][j], result[i][j - 1]);
			}
		}

		return result[grid.length - 1][grid[0].length - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
