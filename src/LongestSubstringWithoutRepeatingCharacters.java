public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		if (s.length() == 1)
			return 1;

		int max = 0;
		int currentLength = 0;

		for (int i = 0; i < s.length(); i++) {
			currentLength = 0;
			for (int j = i; j < s.length(); j++) {
				if (j == i) {
					currentLength = 1;
				} else if (j == s.length() - 1) {
					if (!s.substring(i, j).contains(
							Character.toString(s.charAt(j)))) {
						currentLength++;
					}
					max = Math.max(max, currentLength);
				}

				else {
					if (!s.substring(i, j).contains(
							Character.toString(s.charAt(j)))) {
						currentLength++;
					} else {
						max = Math.max(max, currentLength);
						break;
					}
				}

			}
		}

		return max;

		// int[][] resultArray = new int[s.length()][s.length()];
		// char[] charArray = s.toCharArray();
		// resultArray[0][s.length()] = 0;
		//
		// for (int i = 0; i < s.length(); i++) {
		// resultArray[i][i] = 1;
		// }
		//
		// int j;
		// int current1 = 0;
		// int current2 = 0;
		//
		// for (int offsetBetweenIJ = 1; offsetBetweenIJ < s.length();
		// offsetBetweenIJ++) {
		// for (int i = 0; i < s.length() - offsetBetweenIJ; i++)
		//
		// {
		// current1 = 0;
		// current2 = 0;
		// j = offsetBetweenIJ + i;
		// if (!s.substring(i, j)
		// .contains(Character.toString(s.charAt(j)))) {
		// current1 = resultArray[i][j - 1] + 1;
		// }
		// else
		// {
		// current1 = resultArray[i][j - 1];
		// }
		// if (!s.substring(i + 1, j + 1).contains(
		// Character.toString(s.charAt(i)))) {
		// current2 = resultArray[i + 1][j] + 1;
		// }
		// resultArray[i][j] = Math.max(current1, current2);
		//
		// }
		// }

	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("qopubjguxhxdipfzwswybgfylqvjzhar"));

	}

}
