public class InterleavingString {

	public static boolean isInterleave(String s1, String s2, String s3) {
		if (!((s1.length() + s2.length()) == s3.length()))
			return false;

		boolean[][] result = new boolean[s1.length() + 1][s2.length() + 1];

		result[0][0] = true;

		for (int i = 1; i <= s1.length(); i++) {
			result[i][0] = s3.substring(0, i) == s1.substring(0, i);
		}

		for (int i = 1; i <= s2.length(); i++) {
			result[0][i] = s3.substring(0, i) == s2.substring(0, i);
		}

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				result[i][j] = (result[i - 1][j] && (s3.charAt(i + j - 1) == s1
						.charAt(i - 1)))
						|| (result[i][j - 1] && (s3.charAt(i + j - 1) == s2
								.charAt(j - 1)));
			}
		}

		return result[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		String s1 = "a";
		String s2 = "";
		String s3 = "a";

		System.out.println(isInterleave(s1, s2, s3));

	}

}
