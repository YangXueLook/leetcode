public class SearchInsertPosition {

	public static int searchInsert(int[] A, int target) {
		int low = 0;
		int high = A.length - 1;
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;
			if (A[mid] == target)
				return mid;
			else {
				if (A[mid] > target)
					high = mid - 1;
				else
					low = mid + 1;
			}
		}

		return high + 1;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 3, 5, 6 };
		System.out.println(searchInsert(a, 5));
		System.out.println(searchInsert(a, 2));
		System.out.println(searchInsert(a, 7));
		System.out.println(searchInsert(a, 0));

	}

}
