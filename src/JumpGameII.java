public class JumpGameII {

	public int jump(int[] A) {
		int result = 0;
		int previousReachableIndex = 0;
		int currentReachableIndex = 0;
		
		for(int i = 0; i <A.length && i <= currentReachableIndex; i++)
		{
			if(i > previousReachableIndex)
			{
				result++;
				previousReachableIndex = currentReachableIndex;
			}
			currentReachableIndex = Math.max(currentReachableIndex, i+A[i]);
		}
		if(currentReachableIndex < A.length - 1)
			return -1;
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
