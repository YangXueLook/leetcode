public class SingleNumber {
	public int singleNumber(int[] A) {
		int result = 0;

		for (int i = 0; i < A.length; i++) {
			result = result ^ A[i];
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
