public class RemoveDuplicatedII {

	public static int removeDuplicates(int[] A) {
		if (A == null)
			return 0;

		if (A.length == 0)
			return 0;

		int length = 0;
		int newIndex = 0;
		int currentDuplicatedTimes = 0;
		int previousValue = 0;

		for (int i = 0; i < A.length; i++) {
			if (i == 0) {
//				System.out.println("111111111");
				previousValue = A[i];
				newIndex++;
				currentDuplicatedTimes++;
				length++;
			} else {

				if (previousValue == A[i]) {
					if (currentDuplicatedTimes == 1) {
						currentDuplicatedTimes++;
						A[newIndex] = A[i];
						newIndex++;
						currentDuplicatedTimes++;
						length++;

					} else {
						currentDuplicatedTimes++;
					}

//					System.out.println("222222222");

				} else {
//					System.out.println("3333333333");
					previousValue = A[i];
					A[newIndex] = A[i];
					newIndex++;
					currentDuplicatedTimes = 1;
					length++;
				}
			}
		}

		return length;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 1, 1, 2, 2, 3 };

		System.out.println(removeDuplicates(a));
		
		for(int i = 0; i < 5; i++)
			System.out.println(a[i]);

	}

}
