public class SortColors {

	public static void sortColors(int[] A) {
		if(A.length == 0||A.length == 1)
			return;
		int zeroIndex = 0;
		int twoIndex = A.length - 1;
		int currentIndex = 0;
		int tempValue;
		
		while(currentIndex <= twoIndex)
		{
			if(A[currentIndex] == 0)
			{
				if(zeroIndex == currentIndex)
				{
					zeroIndex++;
					currentIndex++;
					continue;
				}
				else
				{
					tempValue = A[currentIndex];
					A[currentIndex] = A[zeroIndex];
					A[zeroIndex] = tempValue;
					zeroIndex++;
					currentIndex++;
					continue;
				}
			}
			if(A[currentIndex] == 1)
			{
				currentIndex++;
				continue;
			}
			if(A[currentIndex] == 2)
			{
				if(A[twoIndex] == 2)
				{
					twoIndex--;
					continue;
				}
				else
				{
					tempValue = A[currentIndex];
					A[currentIndex] = A[twoIndex];
					A[twoIndex] = tempValue;
					twoIndex--;
					continue;
				}
				
			}
			
			
		}

	}

	public static void main(String[] args) {
		int[] a = new int[]{1,0};
		sortColors(a);
		for(int i = 0; i < a.length; i++)
		{
			System.out.println(a[i]);
		}

	}

}
