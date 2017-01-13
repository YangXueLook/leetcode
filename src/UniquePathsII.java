public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int[][] resultGrid = new int[m][n];

		boolean VBlocked = false;

		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 0 && !VBlocked) {
				resultGrid[i][0] = 1;
			}
			if (obstacleGrid[i][0] == 0 && VBlocked) {
				resultGrid[i][0] = 0;
			}
			if (obstacleGrid[i][0] == 1) {
				resultGrid[i][0] = 0;
				VBlocked = true;
			}
		}
		boolean HBlocked = false;

		for (int i = 0; i < n; i++) {
			if (obstacleGrid[0][i] == 0 && !HBlocked) {
				resultGrid[0][i] = 1;
			}
			if (obstacleGrid[0][i] == 0 && HBlocked) {
				resultGrid[0][i] = 0;
			}
			if (obstacleGrid[0][i] == 1) {
				resultGrid[0][i] = 0;
				HBlocked = true;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 0)
					resultGrid[i][j] = resultGrid[i - 1][j]
							+ resultGrid[i][j - 1];
				else
					resultGrid[i][j] = 0;
			}
		}

		return resultGrid[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
