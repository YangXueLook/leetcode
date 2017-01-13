import java.util.Scanner;


public class LoadingTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int loopTimes = scan.nextInt();
		
		String[] result = new String[loopTimes];
		for(int i = 0; i < loopTimes; i++)
		{
			int l = scan.nextInt();
			int p = scan.nextInt();
			int c = scan.nextInt();
			
			result[i] = String.valueOf(helper(l, p , c));
		}
		for(int i = 0; i < loopTimes; i++)
			System.out.println("Case #"+ (i + 1)+": "+ result[i]);

	}

	private static int helper(int l, int p, int c) {
		// TODO Auto-generated method stub
		int times = p/l;
		int result = (int) (Math.log(times)/Math.log(c));
		if(Math.pow(c, result) == times)
			return result;
		else
			return result - 1;
		
	}

}
