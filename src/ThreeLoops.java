import java.util.Scanner;

public class ThreeLoops {

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);
		int n, sum;
		n = sc.nextInt();
		sum = sc.nextInt();
		int ans = 0;
		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				if (!((sum - a - b) <= n))
					break;
				for (int c = sum - a - b; c <= sum - a - b; c++) {
					if (a + b + c == sum) {
						ans++;
						
						System.out.println(a+"\t"+b+"\t"+c);
					}
				}

			}

		}
		System.out.println(ans);
	}

}
