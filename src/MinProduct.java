import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class MinProduct {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int loopTimes = scan.nextInt();
		
		String[] result = new String[loopTimes];
		for(int i = 0; i < loopTimes; i++)
		{
			int length = scan.nextInt();
			ArrayList<Integer> listA = new ArrayList<Integer>();
			for(int j = 0; j < length; j++)
				listA.add(scan.nextInt());
			ArrayList<Integer> listB = new ArrayList<Integer>();
			for(int j = 0; j < length; j++)
				listB.add(scan.nextInt());
			
			result[i] = String.valueOf(helper(listA , listB));
		}
		for(int i = 0; i < loopTimes; i++)
			System.out.println("Case #"+ (i + 1)+": "+ result[i]);


	}

	private static long helper(ArrayList<Integer> listA,
			ArrayList<Integer> listB) {
		// TODO Auto-generated method stub
		Collections.sort(listA);
		Collections.sort(listB);
		long sum = 0;
		long Amin;
		long Bmax;
		while(listA.size() != 0)
		{
			Amin = listA.remove(0);
			Bmax = listB.remove(listB.size() -  1);
			sum = sum + Amin*Bmax;
		}
		
		
		
		
		return sum;
	}

}
