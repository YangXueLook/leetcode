import java.util.Scanner;


public class Wire {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int loopTimes = scan.nextInt();
		
		String[] result = new String[loopTimes];
		for(int i = 0; i < loopTimes; i++)
		{
			int pairNumber = scan.nextInt();
			int[] arrayA = new int[pairNumber];
			int[] arrayB = new int[pairNumber];
			for(int j = 0; j < pairNumber; j++)
			{
				arrayA[j] = scan.nextInt();
				arrayB[j] = scan.nextInt();
			}
			
			
			result[i] = String.valueOf(helper(arrayA, arrayB));
			
		}
		for(int i = 0; i < loopTimes; i++)
			System.out.println("Case #"+ (i + 1)+": "+ result[i]);

	}

	private static int helper(int[] arrayA, int[] arrayB) {
//		for(int i = 0; i < arrayA.length; i++)
//			System.out.print(arrayA[i]);
		
		
		int result = 0;
		for(int i = 0; i < arrayA.length; i++)
		{
			for(int j = i + 1; j < arrayA.length; j++)
			{
				if((arrayA[i] > arrayA[j]) && (arrayB[i] < arrayB[j]))
					result++;
				else if((arrayA[i] < arrayA[j]) && (arrayB[i] > arrayB[j]))
					result++;
			}
		}
		
		
		
		return result;
	}

}
