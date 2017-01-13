
public class NumberOfOccurance {
	
	public static int find(int[] array, int target)
	{
		int low = 0;
		int high = array.length - 1;
		
		int mid = (low + high)/2;
		
		while(low < high)
		{
			if(array[mid] == target)
				break;
			else if(array[mid] < target)
				low = mid + 1;
			else
				high = mid - 1;
			
			mid = (low + high)/2;
		}
		
		System.out.println("mid"+mid);
		
		if(array[mid] != target)
			return -1;
		
		int l1 = low;
		int h1 = mid;
		
		int leftBound = (l1 + h1)/2;
		
		while(l1 < h1)
		{
			if(array[leftBound] == target && (leftBound == 0 || array[leftBound - 1 ] != target))
					break;
			else if(array[leftBound] == target && array[leftBound - 1 ] == target)
				h1 = leftBound - 1;
			else
				l1 = leftBound + 1;
			
			leftBound = (l1 + h1)/2;
		}
		
		int l2 = mid;
		int h2 = high;
		
		int rightBound = (l2 + h2)/2;
		
		while(l2 < h2)
		{
			if(array[rightBound] == target && (rightBound == array.length - 1 || array[rightBound + 1 ] != target))
					break;
			else if(array[rightBound] == target && array[rightBound + 1] == target)
				l2 = rightBound + 1;
			else
				h2 = rightBound - 1;
			
			rightBound = (l2 + h2)/2;
		}
		
		
		
		
		return rightBound - leftBound + 1;
	}

	public static void main(String[] args) {
		System.out.println(find(new int[]{1,2,2,2,2,20}, 2));

	}

}
