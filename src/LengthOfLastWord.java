public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		String[] a = s.split(" ");
		if (a.length == 0)
			return 0;

		return a[a.length - 1].length();
	}

	public static void main(String[] args) {
		String s = "  ";

		String[] a = s.split(" ");

		for (int i = 0; i < a.length; i++)
			System.out.println(a[i] + "\t" + a[i].length());

	}

}
