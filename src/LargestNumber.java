import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static String largestNumber(int[] num) {
		if (num == null || num.length == 0)
			return "0";

		String[] array = new String[num.length];
		for (int i = 0; i < num.length; i++)
			array[i] = Integer.toString(num[i]);

		Arrays.sort(array, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int length = Math.min(o1.length(), o2.length());
				for (int i = 0; i < length; i++) {
					if (o1.charAt(i) < o2.charAt(i))
						return -1;
					else if (o1.charAt(i) > o2.charAt(i))
						return 1;
				}
				if (o1.length() == o2.length())
					return 0;
				else if (o1.length() < o2.length()) {
					String s = o2.substring(length) + o1;
					return Integer.parseInt(o2) - Integer.parseInt(s);
				} else {
					String s = o1.substring(length) + o2;
					return Integer.parseInt(s) - Integer.parseInt(o1);
				}

			}

		});

		StringBuffer sb = new StringBuffer();
		for (int i = array.length - 1; i >= 0; i--)
			sb.append(array[i]);

		while (sb.length() > 0 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);
		if(sb.length() == 0)
			return "0";
		
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] number = new int[] {0 };
		System.out.println(Integer.MAX_VALUE);

	}

}
