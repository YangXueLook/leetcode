public class AddBinary {

	public static String addBinary(String a, String b) {
		String longer, shorter;

		if (a.length() <= b.length())

		{
			longer = b;
			shorter = a;

		} else {
			longer = a;
			shorter = b;
		}

		StringBuffer tempResult = new StringBuffer();
		boolean carry = false;

		for (int i = 0; i < shorter.length(); i++) {
			char c1 = longer.charAt(longer.length() - i - 1);
			char c2 = shorter.charAt(shorter.length() - i - 1);
			if (i == 0) {
				if (c1 == '1' && c2 == '1') {
					carry = true;
					tempResult.append('0');
				} else if (c1 == '0' && c2 == '0') {
					carry = false;
					tempResult.append('0');
				} else {
					carry = false;
					tempResult.append('1');
				}
			}

			else {
				if (c1 == '1' && c2 == '1') {
					if (carry) {
						carry = true;
						tempResult.append('1');
					} else {
						carry = true;
						tempResult.append('0');
					}

				} else if (c1 == '0' && c2 == '0') {
					if (carry) {
						carry = false;
						tempResult.append('1');
					} else {
						carry = false;
						tempResult.append('0');
					}

				} else {

					if (carry) {
						carry = true;
						tempResult.append('0');
					} else {
						carry = false;
						tempResult.append('1');
					}
				}
			}

		}

		for (int i = longer.length() - shorter.length() - 1; i >= 0; i--) {
			char c = longer.charAt(i);
			if (c == '1' && carry) {
				carry = true;
				tempResult.append('0');
			} else if (c == '0' && carry) {
				carry = false;
				tempResult.append('1');
			} else {
				tempResult.append(c);
			}
		}
		if (carry) {
			tempResult.append('1');
		}

		StringBuffer result = new StringBuffer();
		for (int i = tempResult.length() - 1; i >= 0; i--) {
			result.append(tempResult.charAt(i));
		}

		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(addBinary("10", "1111"));

	}

}
