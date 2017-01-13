public class Divide {

	public static int positiveDivide(int dividend, int divisor) {

		if (dividend < divisor)
			return 0;

		int powerOfTwo = 0;
		int currentSum = divisor;
		while (currentSum < dividend) {
			powerOfTwo++;
			currentSum = currentSum + currentSum;
		}
		System.out.println("powerOfTwo" + powerOfTwo + "    " + "currentSum"
				+ currentSum);

		if (currentSum == dividend) {
			return (int) Math.pow(2, powerOfTwo);
		} else {
			return (int) Math.pow(2, powerOfTwo - 1)
					+ positiveDivide(
							dividend - (int) Math.pow(2, powerOfTwo - 1)
									* divisor, divisor);
		}

	}

	public static int divide(int dividend, int divisor) {
		if (dividend == 0)
			return 0;
		else if(divisor == 1)
			return dividend;

		else if (dividend > 0 && divisor > 0)
			return positiveDivide(dividend, divisor);

		else if (dividend < 0 && divisor < 0)
			return positiveDivide(-dividend, -divisor);
		else if (dividend > 0 && divisor < 0)
			return -positiveDivide(dividend, -divisor);
		else
			return -positiveDivide(-dividend, divisor);
	}

	public static void main(String[] args) {
		System.out.println(divide(2147483647, 1));

	}

}
