public class ExcelTitle {

	public static String convertToTitle(int n) {
		StringBuffer result = new StringBuffer();
		int temp;
		char c;
		while (n > 0) {
			temp = n % 26;
			if (temp != 0) {
				c = (char) ('A' + temp - 1);
				result.append(c);
				n = n / 26;
			} else {
				result.append('Z');
				n = (n - 26) / 26;
			}

		}

		return result.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(28));

	}

}
