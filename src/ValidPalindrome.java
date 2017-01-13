import java.util.ArrayList;

public class ValidPalindrome {

	public static boolean isPalindrome(String s) {
		if(s == null)
			return false;
		
		ArrayList<Character> charArray = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')|| (c >= '0' && c <= '9')) {
				charArray.add(c);
			}
		}

		if (charArray.size() == 0)
			return true;
		int size = charArray.size();
		
		int offset = 'a'-'A';;

		for (int i = 0; i < size / 2; i++) {
			if (!((charArray.get(i) == charArray.get(size - i - 1))|| ((Math.abs(charArray.get(size - i - 1) - charArray.get(i)) ==  offset))))
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("race a car"));

	}

}
