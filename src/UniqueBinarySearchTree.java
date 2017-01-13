public class UniqueBinarySearchTree {

	public static int numTrees(int n) {
		if (n < 0)
			return 0;
		else if (n == 1 || n == 0)
			return 1;
		else if (n == 2)
			return 2;
		else if (n == 3)
			return 5;

		int[] resultArray = new int[n + 1];
		for (int i = 0; i < resultArray.length; i++)
			resultArray[i] = 0;

		resultArray[0] = 1;
		resultArray[1] = 1;
		resultArray[2] = 2;
		resultArray[3] = 5;

		for (int i = 4; i <= n; i++) {
			for (int root = 1; root <= i; root++) {
				resultArray[i] = resultArray[i] + resultArray[root - 1]
						* resultArray[i - root];
			}
		}

		return resultArray[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(5));
	}

}
