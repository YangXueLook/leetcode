public class MultiplyStrings {
	public static String stringMultiplyChar(String s, char c) {
		StringBuffer result = new StringBuffer();
		int multiplyer = Integer.parseInt(Character.toString(c));
		int temp;
		int carry = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			temp = Integer.parseInt(Character.toString(s.charAt(i)))
					* multiplyer;
			result.append((temp + carry) % 10);

			carry = (temp + carry) / 10;

		}

		if (carry != 0)
			result.append(carry);
		result.reverse();

		return result.toString();

	}

	public static String addTwoStrings(String a, String b) {
		StringBuffer result = new StringBuffer();
		int carry = 0;
		if (a.length() < b.length()) {
			String temp = a;
			a = b;
			b = temp;
		}

		String a1 = a.substring(0, a.length() - b.length());
		String a2 = a.substring(a.length() - b.length(), a.length());

		int abit;
		int bbit;
		int temp;
		for (int i = b.length() - 1; i >= 0; i--) {
			abit = Integer.parseInt(Character.toString(a2.charAt(i)));
			bbit = Integer.parseInt(Character.toString(b.charAt(i)));

			temp = carry + abit + bbit;
			result.append(temp % 10);
			carry = temp / 10;
		}

		if (a1.length() == 0 && carry == 1)
			result.append(1);

		else {
			for (int i = a1.length() - 1; i >= 0; i--) {
				abit = Integer.parseInt(Character.toString(a1.charAt(i)));
				temp = carry + abit;
				result.append(temp % 10);
				carry = temp / 10;
			}
			if (carry == 1) {
				result.append(1);
			}
		}
		result.reverse();

		return result.toString();
	}

	public static String multiply(String num1, String num2) {
		String result = "";
		String temp;
		StringBuffer zeros = new StringBuffer();
		for (int i = num2.length() - 1; i >= 0; i--) {
			if (result == "") {
				result = stringMultiplyChar(num1, num2.charAt(i));
			} else {
				int numOfZeros = num2.length() - i - 1;
				zeros = new StringBuffer();

				for (int j = 0; j < numOfZeros; j++) {
					zeros.append(0);
				}

				temp = stringMultiplyChar(num1, num2.charAt(i)) + zeros;
				result = addTwoStrings(temp, result);
			}
		}

		boolean allZeros = true;
		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(i) != '0') {
				allZeros = false;
				break;
			}
		}
		if (allZeros)
			return "0";

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "1111";
		char b = '9';

		// System.out.println(stringMultiplyChar(a, b));
		// System.out.println(addTwoStrings("99", "13"));

		System.out.println(multiply("111", "0"));

	}

}
