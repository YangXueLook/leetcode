
public class FindMaxInUpAndDownArray {
	public static int findMax(int[] array)
	{
		if(array == null || array.length == 0)
			return Integer.MIN_VALUE;
		else if(array.length == 1)
			return array[0];
		else if(array.length == 2)
			return Math.max(array[0],array[1]);
		
		int low = 0; 
		int high = array.length - 1;
		int mid = (low + high)/2;
		while(low < high)
		{
			mid = (low + high)/2;
			if(array[mid] >= array[mid - 1] && array[mid] >= array[mid + 1])
				return array[mid];
			else if(array[mid] >= array[mid - 1]&& array[mid] <= array[mid + 1])
				low = mid;
			else
				high = mid;
		}
		
		return array[mid];
	}
	

	public static void main(String[] args) {
		int[] array = new int[]{0,3,4,3,1};
		System.out.println(findMax(array));

	}

}
