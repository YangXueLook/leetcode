import java.util.Random;


public class KthLargest {
	
	private int partition(int[] array, int start, int end)
	{
		int pivot = array[start];
		int low = start + 1;
		int high = end;
		int temp;
		while(true)
		{
			
			while(array[low] <= pivot && low < end)
				low++;
			
			while(array[high] > pivot)
				high--;
			
			if(low >= high)
				break;
			else
			{
				temp = array[low];
				array[low] = array[high];
				array[high] = temp;
			}
		}
		array[start] = array[high];
		array[high] = pivot;
		
		return high;
		
	}
	
	private int randomSelectedPivotPartition(int[] array, int start, int end)
	{
		Random random = new Random();
		int r = start + random.nextInt(end - start);
		int temp = array[r];
		array[r] = array[start];
		array[start] = temp;
		
		return partition(array, start, end);
		
	}
	
	public int findKthLargest(int[] nums, int k) {
		k = nums.length - k + 1;
		
        return helper(nums, k, 0, nums.length - 1);
    }
	
	

	private int helper(int[] nums, int k, int start, int end) {
		
		
		if(start == end)
			return nums[start];
		
		int i = randomSelectedPivotPartition(nums, start, end);
		
		int offset = i - start + 1;
		
		if(offset == k)
			return nums[i];
		else if(offset > k)
			return helper(nums,k, start, i - 1);
		else
			return helper(nums,k - offset, i + 1, end);

	}

	public static void main(String[] args) {
		KthLargest t = new KthLargest();
		int[] array = new int[]{1,1};
//		System.out.println(t.partition(array, 0, array.length - 1));
//		for(int num: array)
//			System.out.print(num);
//		System.out.println();
		System.out.println(t.findKthLargest(array, 1));

	}

}
