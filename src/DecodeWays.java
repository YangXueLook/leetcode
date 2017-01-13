public class DecodeWays {

	public int numDecodings(String s) {
		if (s.length() == 0)
			return 0;
		if (s.startsWith("0"))
			return 0;
		else if (s.length() == 1) {
			int num = Integer.parseInt(s);
			if (num > 0)
				return 1;
			else
				return 0;
		}

		else if (s.length() == 2) {
			

			int num = Integer.parseInt(s);
			if (num%10 == 0 && num > 20) {
				return 0;
			} else if (num > 26 || num == 10 || num == 20) {
				return 1;
			} else {
				return 2;
			}
		} else {
			int num = Integer.parseInt(s.substring(0, 2));

			if (num > 26 || num == 10 || num == 20) {
				return numDecodings(s.substring(2, s.length()));
			} else {
				return numDecodings(s.substring(2, s.length()))
						+ numDecodings(s.substring(1, s.length()));
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
