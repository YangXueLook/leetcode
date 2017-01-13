public class Sqrt {

	public static int sqrt(int x) {
		if (x < 0)
			System.err.close();

		if (x == 0)
			return 0;

		int lower = 0;
		int higher = 46341;
		int mid;
		while (true) {
			mid = (higher + lower) / 2;
//			System.out.println("mid is " + mid + " (mid + 1) * (mid + 1) is "
//					+ (mid + 1) * (mid + 1));

			if(mid == 46340)
				return 46340;
			
			if (mid * mid > x && (mid - 1) * (mid - 1) <= x) {

				return mid - 1;
			}

			else if (mid * mid > x)
				higher = mid;

			else if (mid * mid <= x && (mid + 1) * (mid + 1) > x)

			{

				return mid;
			}

			else if (mid * mid < x)
				lower = mid;

		}

	}

	public static void main(String[] args) {
		// for (int i = 0; i <= 100; i++)
		System.out.println("sqrt is " + sqrt(2147395600) + " and is is "
				+ 2147395600);

	}

}
