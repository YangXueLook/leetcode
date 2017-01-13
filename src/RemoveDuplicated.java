public class RemoveDuplicated {

	public static int removeDuplicates(int[] A) {
		if (A == null)
			return 0;

		if (A.length == 0)
			return 0;

		int length = 0;
		int newIndex = 0;
		int oldIndex = 0;
		int previousValue = 0;

		for (int i = 0; i < A.length; i++) {
			if (i == 0) {
				System.out.println("111111111");
				previousValue = A[i];
				newIndex++;
				oldIndex++;
				length++;
			} else {
				
				if (previousValue == A[i]) {
					System.out.println("222222222");
					oldIndex++;
				} else {
					System.out.println("3333333333");
					previousValue = A[i];
					A[newIndex] = A[i];
					newIndex++;
					oldIndex++;
					length++;
				}
			}
		}

		return length;
	}

	public static void main(String[] args) {
		int a[] = new int[] { 1, 1, 2 };
		System.out.println(removeDuplicates(a));
		System.out.println(a[0]+"\t"+a[1]+"\t"+a[2]);

	}

}
