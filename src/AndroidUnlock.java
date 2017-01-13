public class AndroidUnlock {

	int DFS(boolean vis[], int[][] skip, int cur, int remain) {
		if (remain < 0)
			return 0;
		if (remain == 0)
			return 1;
		vis[cur] = true;
		int rst = 0;
		for (int i = 1; i <= 9; ++i) {
			// If vis[i] is not visited and (two numbers are adjacent or skip
			// number is already visited)
			if (!vis[i] && (skip[i][cur] == 0 || (vis[skip[i][cur]]))) {
				rst += DFS(vis, skip, i, remain - 1);
			}
		}
		vis[cur] = false;
		return rst;
	}

	public int numberOfPatterns(int m, int n) {
		int[][] bridges = new int[10][10];
		bridges[1][3] = bridges[3][1] = 2;
		bridges[1][7] = bridges[7][1] = 4;
		bridges[9][3] = bridges[3][9] = 6;
		bridges[9][7] = bridges[7][9] = 8;
		bridges[1][9] = bridges[9][1] = bridges[2][8] = bridges[8][2] = bridges[3][7] = bridges[7][3] = bridges[4][6] = bridges[6][4] = 5;

		int result = 0;
		boolean[] visited = new boolean[10];
		
		for(int i = m; i <= n; i++)
		{
			result = result + 4 * helper(1, visited, i - 1, bridges);
			result = result + 4 * helper(2, visited, i - 1, bridges);
			result = result +  helper(5, visited, i - 1, bridges);
			
		}
		
		
		return result;
	}

	private int helper(int start, boolean[] visited, int remainingSteps, int[][] bridges) {
		if(remainingSteps == 0)
			return 1;
		int result = 0;
		
		visited[start] = true;
		for(int i = 1; i <= 9; i++)
		{
			if(!visited[i] && (bridges[start][i] == 0 || visited[bridges[start][i]]))
			{
				result = result + helper(i, visited, remainingSteps - 1, bridges);
			}
		}

		visited[start] = false;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
