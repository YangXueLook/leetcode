import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	public static List<String> restoreIpAddresses(String s) {

		ArrayList<String> result = new ArrayList<String>();
		String temp = "";
		if (s.length() < 4 || s.length() > 12)
			return null;
		for (int i = 0; i <= s.length() - 4; i++) {
			for (int j = i + 1; j <= s.length() - 3; j++) {
				for (int k = j + 1; k <= s.length() - 2; k++) {
					String s1 = s.substring(0, i + 1);
					String s2 = s.substring(i + 1, j + 1);
					String s3 = s.substring(j + 1, k + 1);
					String s4 = s.substring(k + 1, s.length());
					System.out.println("i==" + i + "  j==" + j + "  k==" + k);
					System.out.println(s1 + "  " + s2 + "  " + s3 + "  " + s4);
					if (!(s1.length() > 3 || s2.length() > 3 || s3.length() > 3 || s4
							.length() > 3)) {
						System.out.println("111");
						if (Integer.parseInt(s1) <= 255
								&& Integer.parseInt(s2) <= 255
								&& Integer.parseInt(s3) <= 255
								&& Integer.parseInt(s4) <= 255) {
							System.out.println("222");
							System.out.println("  anddddd " + s1);
							if (!((s1.startsWith("0") && !s1.equals("0"))
									|| (s2.startsWith("0") && !s2.equals("0"))
									|| (s3.startsWith("0") && !s3.equals("0")) || (s4
									.startsWith("0") && !s1.equals("0")))) {

								temp = "";
								temp = s1 + "." + s2 + "." + s3 + "." + s4;
								result.add(temp);

							}

						}
					}

				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		restoreIpAddresses("0000");
		// String s = "0";
		// System.out.print(s == "0");

	}

}
