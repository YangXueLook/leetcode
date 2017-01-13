public class Power {

	public double help(double x, int n) {
		double result = 1;
		if (n == 1)
			return x;
		else {

			if (n % 2 == 0) {
				double temp = pow(x, n / 2);
				result = temp * temp;
			}

			else {
				double temp = pow(x, n / 2);
				result = temp * temp * x;
			}

			return result;

		}
	}

	public double pow(double x, int n) {
		
		if (n == 0)
			return (double)1;
		else if (n > 0)
			return help(x, n);
		else
			return 1 / help(x, (-1) * n);

	}

	public static void main(String[] args) {
		System.out.print(new Power().pow(2, -5));

	}

}
