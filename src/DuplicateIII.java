import java.util.TreeSet;

public class DuplicateIII {

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0 || nums == null || nums.length == 0)
			return false;
		
		TreeSet<Long> set = new TreeSet<Long>();
		
		for(int i = 0; i < nums.length; i++)
		{
			Long upperBound = set.floor((long) (nums[i] + t));
			Long lowerBound = set.ceiling((long) (nums[i] - t));
			
			
			
			if(upperBound != null && upperBound >= (long)nums[i] - (long)t)
				return true;
			if(lowerBound != null && lowerBound <= (long)nums[i] + (long)t)
				return true;
			set.add((long) nums[i]);
			if(i >= k)
				set.remove((long)nums[i - k]);
			
		}
		
		return false;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {0,2147483647};
		System.out.println(containsNearbyAlmostDuplicate(nums, 1, 2147483647));

	}

}
