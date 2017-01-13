public class SearchinRotatedSortedArray {

	public int search(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;
		int mid;
		
		while(!(start > end))
		{
			mid = (start + end)/2;
			if(target == A[mid])
				return mid;
			if(A[start] <= A[mid])
			{
				if(target >= A[start] && target <= A[mid])
				{
					end = mid - 1;
				}
				else
				{
					start = mid + 1;
				}
			}
			
			else
			{
				if(target >= A[mid] && target <= A[end])
				{
					
					start = mid + 1;
				}
				else
				{
					end = mid - 1;
				}
			}
			
		}
		

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
