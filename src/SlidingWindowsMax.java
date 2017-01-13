import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowsMax {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] result = new int[nums.length - k + 1];
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}});
		
		for(int i = 0; i < k; i++)
			queue.add(nums[i]);
		
		result[0] = queue.peek();
		
		for(int i = k; i < nums.length; i++)
		{
			queue.remove(nums[i - k]);
			queue.add(nums[i]);
			result[i - k + 1] = queue.peek();
		}
		

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
