
public class TwoSortedArraySum {
	public static void findPairs(int[] A, int[] B, int target)
	{
		int indexA = 0;
		int indexB = B.length - 1;
		
		while(indexA < A.length && indexB >= 0)
		{
			if(A[indexA] + B[indexB] == target)
			{
				System.out.println(A[indexA] + "\t"+ B[indexB]);
				indexA++;
				indexB--;
			}
			else if(A[indexA] + B[indexB] > target)
				indexB--;
			else
				indexA++;
		}
		
	}
	

	public static void main(String[] args) {
		int[] A = new int[]{1,3,5,8,9};
		int[] B = new int[]{2,3,4,9,11};
		
		findPairs(A, B, 12);
		System.out.println("----");
		
		for(int i: A)
		{
			for(int j : B)
				if(i + j == 12)
					System.out.println(i+"\t"+j);
		}

	}

}
