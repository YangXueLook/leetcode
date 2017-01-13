public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int reverseFinalIndex = m + n - 1;
		int reverseAIndex = m - 1;
		int reverseBIndex = n - 1;

		while (reverseAIndex >= 0 && reverseBIndex >= 0) {
			if (A[reverseAIndex] > B[reverseBIndex]) {
				A[reverseFinalIndex] = A[reverseAIndex];
				reverseFinalIndex--;
				reverseAIndex--;
			} else {
				A[reverseFinalIndex] = B[reverseBIndex];
				reverseFinalIndex--;
				reverseBIndex--;
			}

		}

		if (reverseBIndex > 0) {
			while (reverseBIndex > 0) {
				A[reverseFinalIndex] = B[reverseBIndex];
				reverseFinalIndex--;
				reverseBIndex--;
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
