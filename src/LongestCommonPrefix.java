public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		if (strs == null||strs.length == 0)
			return null;
		else if (strs[0] == null)
			return null;

		StringBuffer result = new StringBuffer();
		char current;
		boolean stop = false;
		

		for (int i = 0; i < strs[0].length() && !stop; i++) {
			current = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].length() <= i || strs[j].charAt(i) != current) {
					stop = true;
				}
			}

			if (!stop) {
				result.append(current);
			}
		}

		return result.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
