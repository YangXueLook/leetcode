public class MedianOfTwoSortedArray {
	public double assitant(int A[], int startIndexA, int endIndexA, int B[],
			int startIndexB, int endIndexB) {
		if (endIndexA == startIndexA) {
			if (endIndexB == startIndexB)
				return (double) (A[endIndexA] + B[endIndexB]) / 2;
			else if ((endIndexB - startIndexB + 1) % 2 == 0) {
				if (A[endIndexA] > B[(endIndexB + startIndexB) / 2 + 1])
					return B[(endIndexB + startIndexB) / 2 + 1];
				else if (A[endIndexA] < B[(endIndexB + startIndexB) / 2])
					return B[(endIndexB + startIndexB) / 2];
				else
					return A[endIndexA];
			} else {
				if (A[endIndexA] > B[(endIndexB + startIndexB) / 2 + 1])
					return (double) (B[(endIndexB + startIndexB) / 2] + B[(endIndexB + startIndexB) / 2 + 1]) / 2;
				else if (A[endIndexA] < B[(endIndexB + startIndexB) / 2 - 1])
					return (double) (B[(endIndexB + startIndexB) / 2] + B[(endIndexB + startIndexB) / 2 - 1]) / 2;
				else
					return (double) (B[(endIndexB + startIndexB) / 2] + A[endIndexA]) / 2;
			}
		} else if (endIndexB == startIndexB) {
			if (endIndexA == startIndexA)
				return (double) (A[endIndexA] + B[endIndexB]) / 2;
			else if ((endIndexA - startIndexA + 1) % 2 == 0) {
				if (B[endIndexB] > A[(endIndexA + startIndexA) / 2 + 1])
					return A[(endIndexA + startIndexA) / 2 + 1];
				else if (B[endIndexB] < A[(endIndexA + startIndexA) / 2])
					return A[(endIndexA + startIndexA) / 2];
				else
					return B[endIndexB];
			} else {
				if (B[endIndexB] > A[(endIndexA + startIndexA) / 2 + 1])
					return (double) (A[(endIndexA + startIndexA) / 2] + A[(endIndexA + startIndexA) / 2 + 1]) / 2;
				else if (B[endIndexB] < A[(endIndexA + startIndexA) / 2 - 1])
					return (double) (A[(endIndexA + startIndexA) / 2] + A[(endIndexA + startIndexA) / 2 - 1]) / 2;
				else
					return (double) (A[(endIndexA + startIndexA) / 2] + B[endIndexB]) / 2;
			}
		} else {
			if ((endIndexA - startIndexA + 1) % 2 == 0
					&& (endIndexB - startIndexB + 1) % 2 == 0) {
				if (A[(endIndexA + startIndexA) / 2] == B[(endIndexB + startIndexB) / 2 + 1])
					return A[(endIndexA + startIndexA) / 2];
				else if (A[(endIndexA + startIndexA) / 2 + 1] == B[(endIndexB + startIndexB) / 2])
					return A[(endIndexA + startIndexA) / 2 + 1];
				else if (A[(endIndexA + startIndexA) / 2] == B[(endIndexB + startIndexB) / 2])
					return (double) (A[(endIndexA + startIndexA) / 2] + Math
							.min(A[(endIndexA + startIndexA) / 2 + 1],
									B[(endIndexB + startIndexB) / 2 + 1])) / 2;
				else if (A[(endIndexA + startIndexA) / 2 + 1] == B[(endIndexB + startIndexB) / 2 + 1])
					return (double) (A[(endIndexA + startIndexA) / 2 + 1] + Math
							.max(A[(endIndexA + startIndexA) / 2],
									B[(endIndexB + startIndexB) / 2])) / 2;
				else if (A[(endIndexA + startIndexA) / 2] <= B[(endIndexB + startIndexB) / 2]
						&& A[(endIndexA + startIndexA) / 2 + 1] >= B[(endIndexB + startIndexB) / 2 + 1])
					return (double) (B[(endIndexB + startIndexB) / 2] + B[(endIndexB + startIndexB) / 2 + 1])/2;
				else if (A[(endIndexA + startIndexA) / 2] >= B[(endIndexB + startIndexB) / 2]
						&& A[(endIndexA + startIndexA) / 2 + 1] <= B[(endIndexB + startIndexB) / 2 + 1])
					return (double) (A[(endIndexA + startIndexA) / 2] + A[(endIndexA + startIndexA) / 2 + 1])/2;

				int cutLength = Math.min((endIndexA - startIndexA + 1) / 2,
						(endIndexB - startIndexB + 1) / 2);
				if (A[(endIndexA + startIndexA) / 2] < B[(endIndexB + startIndexB) / 2])
					return assitant(A, startIndexA + cutLength, endIndexA, B,
							startIndexB, endIndexB - cutLength);
				else
					return assitant(A, startIndexA, endIndexA - cutLength, B,
							startIndexB + cutLength, endIndexB);

			} else {
				if (A[(endIndexA + startIndexA) / 2] == B[(endIndexB + startIndexB) / 2])
					return A[(endIndexA + startIndexA) / 2];

				int cutLength = Math.min((endIndexA - startIndexA + 1) / 2,
						(endIndexB - startIndexB + 1) / 2);

				if (A[(endIndexA + startIndexA) / 2] < B[(endIndexB + startIndexB) / 2])
					return assitant(A, startIndexA + cutLength, endIndexA, B,
							startIndexB, endIndexB - cutLength);
				else
					return assitant(A, startIndexA, endIndexA - cutLength, B,
							startIndexB + cutLength, endIndexB);
			}
		}

	}

	public double findMedianSortedArrays(int A[], int B[]) {

		if (A.length == 0)
			return B.length % 2 == 0 ? (double) (B[B.length / 2] + B[B.length / 2 - 1]) / 2
					: B[B.length / 2];

		if (B.length == 0)
			return A.length % 2 == 0 ? (double) (A[A.length / 2] + A[A.length / 2 - 1]) / 2
					: A[A.length / 2];

		return assitant(A, 0, A.length - 1, B, 0, B.length - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianOfTwoSortedArray t = new MedianOfTwoSortedArray();
		int[] A = new int[] { 1, 4 };
		int[] B = new int[] { 2, 3 };
		System.out.println(t.findMedianSortedArrays(A, B));

	}

}
