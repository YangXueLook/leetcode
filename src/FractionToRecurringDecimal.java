public class FractionToRecurringDecimal {

	public int lengthBeforeRepeating(long numerator, long denominator) {
		if (numerator == 0)
			return 0;

		int c2 = 0;

		while (denominator % 2 == 0) {
			c2++;
			denominator = denominator / 2;
		}

		while (numerator % 2 == 0) {
			c2--;
			numerator = numerator / 2;
		}

		int c5 = 0;
		while (denominator % 5 == 0) {
			c5++;
			denominator = denominator / 5;
		}

		while (numerator % 5 == 0) {
			c5--;
			numerator = numerator / 5;
		}

		return Math.max(Math.max(c2, 0), Math.max(c5, 0));

	}

	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		if (denominator == 0)
			return "N/A";

		StringBuffer result = new StringBuffer();
		long n = new Long(numerator);
		long d = new Long(denominator);

		if (n * d < 0)
			result.append("-");

		n = Math.abs(n);
		d = Math.abs(d);

		result.append(n / d);

		n = n % d;

		if (n != 0)
			result.append(".");
		// System.out.println(numerator + ""+denominator);
		int unrepeatedLength = lengthBeforeRepeating(n, d);
		// System.out.println(unrepeatedLength);

		for (int i = 0; i < unrepeatedLength; i++) {
			n = n * 10;
			result.append(n / d);
			n = n % d;
		}

		if (n != 0) {
			long currentStart = n;
			result.append("(");
			do {
				n = n * 10;
				result.append(n / d);
				n = n % d;

			} while (n != currentStart);
			result.append(")");
		}

		return result.toString();
	}

	public static void main(String[] args) {
		// FractionToRecurringDecimal t = new FractionToRecurringDecimal();
		// System.out.println(t.fractionToDecimal(-1, -2147483648));
		//
		// System.out.println(Integer.MIN_VALUE);

		for (int i = 0; i < 700; i++) {
			System.out.println((double) i * 0.1);
		}
	}

}
