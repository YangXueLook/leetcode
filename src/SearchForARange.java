public class SearchForARange {

	public static int[] searchRange(int[] A, int target) {
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;
		
		if(A== null || A.length == 0)
			return result;
		int low = 0;
		int high = A.length - 1;
		int mid = (low+high)/2;
		while(low <= high)
		{
			mid = (low+high)/2;
			if(A[mid] == target)
				break;
			else if(A[mid] > target)
				high = mid-1;
			else
				low = mid+1;
			
			
		}
		
		if(A[mid]!=target)
			return result;
		low = 0;
		high = mid;
		int newMid =(low+high)/2;
		
		while(low <= high)
		{
			newMid = (low+high)/2;
			if(A[newMid] == target)
				high = newMid-1;
			else
				low = newMid+1;
			
		}
		result[0] = low;
		
		
		
		low = mid;
		high = A.length - 1;
		newMid =(low+high)/2;
		
		while(low <= high)
		{
			newMid = (low+high)/2;
			if(A[newMid] == target)
				low = newMid+1;
			else
				high = newMid-1;
		}
		result[1] = high;
		return result;
	}

	public static void main(String[] args) {
		int[] A = new int[]{1,4};
		int[] result = searchRange(A,4);
		System.out.println(result[0]+""+result[1]);

	}

}
