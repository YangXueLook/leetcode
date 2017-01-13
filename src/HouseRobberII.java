public class HouseRobberII {

	public int rob(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		
		if(nums.length == 1)
			return nums[0];
		
		if(nums.length == 2)
			return Math.max(nums[0],nums[1]);
		
		if(nums.length == 3)
			return Math.max(nums[0] + nums[2],nums[1]);
		
		int preOneResult = nums[0];
		int preTwoResult = nums[1];
		int result1 = Math.max(preOneResult, preTwoResult);
		
		for(int i = 2; i < nums.length - 1; i++)
			result1 = Math.max(preTwoResult, preTwoResult + nums[i]);
		
		preOneResult = nums[1];
		preTwoResult = nums[2];
		int result2 = Math.max(preOneResult, preTwoResult);
		for(int i = 3; i < nums.length; i++)
			result2 = Math.max(preTwoResult, preTwoResult + nums[i]);
		
		return Math.max(result1, result2);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
