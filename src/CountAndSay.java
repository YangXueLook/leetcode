public class CountAndSay {

	public static String countAndSay(int n) {
		if (n == 0)
			return null;
		else if (n == 1)
			return "1";
		else if (n == 2)
			return "11";
		else {
			StringBuilder result = new StringBuilder();
			String previousString = countAndSay(n - 1);
			int currentNumber = 0;
			char currentChar;
			char previousChar = '\0';
			for (int i = 0; i < previousString.length(); i++) {
				if (i == 0) {
					previousChar = currentChar = previousString.charAt(i);
					currentNumber++;
				}

				else if (i == previousString.length() - 1) {

					currentChar = previousString.charAt(i);
					if (currentChar == previousChar) {

						currentNumber++;
						result.append(Integer.toString(currentNumber));
						result.append(previousChar);
					} else {

						result.append(Integer.toString(currentNumber));
						result.append(previousChar);
						result.append("1");
						result.append(currentChar);
					}
				}

				else {
					currentChar = previousString.charAt(i);
					if (currentChar == previousChar) {
						currentNumber++;

					} else {
						result.append(Integer.toString(currentNumber));
						result.append(previousChar);
						currentNumber = 1;
						previousChar = currentChar;
					}
				}

			}
			return result.toString();
		}

	}

	public static void main(String[] args) {
		System.out.println(countAndSay(5));

	}

}
