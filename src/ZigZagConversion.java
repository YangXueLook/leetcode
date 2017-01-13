public class ZigZagConversion {

	public static String convert(String s, int nRows) {
		if (nRows == 1)
			return s;

		int sectionSize = 2 * nRows - 2;

		int sectionWidth = nRows - 1;

		int sectionNumber = (int) Math.ceil((double) s.length()
				/ (double) sectionSize);

		char[][] charArray = new char[nRows][sectionNumber * sectionWidth];
		for (int i = 0; i < charArray.length; i++) {
			for (int j = 0; j < charArray[0].length; j++)
				charArray[i][j] = '\0';
		}

		for (int i = 1; i <= sectionNumber; i++) {

			int VCount = 0;
			int DCount = 0;
			for (int index = (i - 1) * sectionSize; index < i * sectionSize
					&& index < s.length(); index++) {

				
				if (VCount < nRows) {
					charArray[VCount][(i - 1) * sectionWidth] = s.charAt(index);

					VCount++;
				} else {
					charArray[nRows - 2 - DCount][(i - 1) * sectionWidth + 1
							+ DCount] = s.charAt(index);

					DCount++;
				}

			}

		}

		StringBuffer result = new StringBuffer();

		for (int i = 0; i < charArray.length; i++) {
			for (int j = 0; j < charArray[0].length; j++) {
				if (!(charArray[i][j] == '\0')) {
					result.append(charArray[i][j]);
				}
			}

		}

		return result.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "twckwuyvbihajbmhmodminftgpdcbquupwflqfiunpuwtigfwjtgzzcfofjpydjnzqysvgmiyifrrlwpwpyvqadefmvfshsrxsltbxbziiqbvosufqpwsucyjyfbhauesgzvfdwnloojejdkzugsrksakzbrzxwudxpjaoyocpxhycrxwzrpllpwlsnkqlevjwejkfxmuwvsyopxpjmbuexfwksoywkhsqqevqtpoohpd";

		System.out.println(convert(s, 4));

	}

}
