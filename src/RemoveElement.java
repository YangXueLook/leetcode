public class RemoveElement {

	public static int removeElement(int[] A, int elem) {
		int offset = 0;
		int targetElementIndex = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				A[targetElementIndex] = A[i];

				targetElementIndex++;
			} else {
				offset++;
			}
		}

		return A.length - offset;
		// for (int i = 0; i < A.length; i++) {
		// if(i == A.length -1)
		// {
		// if (A[i] == elem)
		// {
		// offset++;
		// }
		// }
		//
		//
		// if (A[i] == elem) {
		// if (offset == 0) {
		// offset++;
		// targetElementIndex = i;
		// } else {
		// for (int j = targetElementIndex; j <= i - offset; j++) {
		// A[j] = A[j + offset];
		// }
		// targetElementIndex = i - offset;
		// offset++;
		// }
		//
		// }
		// }

		
	}

	public static void main(String[] args) {
		int a[] = new int[] { 2, 3, 5, 6, 5, 4 };
		 System.out.println(removeElement(a,5));
//		for (int i = 0; i < removeElement(a, 5); i++) {
//			System.out.println(a[i]);
//		}

	}

}
