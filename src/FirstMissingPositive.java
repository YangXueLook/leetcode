public class FirstMissingPositive {

	public void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public int firstMissingPositive(int[] A) {
		if(A.length == 1)
			return A[0] == 1 ? 2 : 1;
		
		int[] assistant = new int[A.length];
		for(int i = 0; i < A.length; i++)
			assistant[i] = Integer.MIN_VALUE;
		for(int i = 0; i < A.length; i++)
		{
			if(A[i] >0 && A[i] <= A.length)
				assistant[A[i] - 1] = i;
		}
		for(int i = 0; i < A.length; i++)
		{
			if(assistant[i] == Integer.MIN_VALUE)
				return i+1;
		}

		return 0;

	}

	public static void main(String[] args) {
		FirstMissingPositive tt = new FirstMissingPositive();
		int A[] = new int[] { 9, 0, 1, 6, -8 };

		int result = tt.firstMissingPositive(A);
		System.out.println(result);

	}

}
