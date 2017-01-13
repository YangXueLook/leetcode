public class LongestPalindromicSubstring {

	public static String longestPalindrome(String s) {

		if (s == null)
			return null;
		if (s.length() == 0 || s.length() == 1)
			return s;

		Boolean[][] dp = new Boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (i >= j)
					dp[i][j] = true;
				else
					dp[i][j] = false;
			}
		}
		int maxLength = 1;
		int currentLength = 0;
		int startIndex = 0;
		int endIndex = 0;
		int j = 0;

		for (int offsetBetweenIJ = 1; offsetBetweenIJ < s.length(); offsetBetweenIJ++) {
			for (int i = 0; i < s.length() - offsetBetweenIJ; i++)

			{
				j = offsetBetweenIJ + i;
				if (s.charAt(i) != s.charAt(j)) {
					dp[i][j] = false;
				} else {
					dp[i][j] = dp[i + 1][j - 1];
					if (dp[i][j]) {
						currentLength = j - i + 1;
						if (currentLength > maxLength) {
							startIndex = i;
							endIndex = j;
							maxLength = currentLength;
						}
					}
				}
			}
		}

		return s.substring(startIndex, endIndex + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("abbbbc"));
	}

}
