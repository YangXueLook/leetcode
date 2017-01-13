import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsofPhoneNumber {
	public List<String> letterCombinations(String digits) {
		HashMap<Character, String[]> map = new HashMap<Character, String[]>();
		map.put('0', new String[] { " " });
		map.put('1', new String[] { " " });
		map.put('2', new String[] { "a", "b", "c" });
		map.put('3', new String[] { "d", "e", "f" });
		map.put('4', new String[] { "g", "h", "i" });
		map.put('5', new String[] { "j", "k", "l" });
		map.put('6', new String[] { "m", "n", "o" });
		map.put('7', new String[] { "p", "q", "r", "s" });
		map.put('8', new String[] { "t", "u", "v" });
		map.put('9', new String[] { "w", "x", "y", "z" });

		List<String> result = new ArrayList<String>();

		if (digits.length() == 0)
			return null;
		else if (digits.length() == 1) {
			String[] stringArray = map.get(digits.charAt(0));
			for (int i = 0; i < stringArray.length; i++) {
				result.add(stringArray[i]);
			}
			return result;
		} else {
			List<String> temp = letterCombinations(digits.substring(1));

			String[] stringArray = map.get(digits.charAt(0));
			for (int i = 0; i < stringArray.length; i++) {
				for (int j = 0; j < temp.size(); j++) {
					result.add(stringArray[i] + temp.get(j));
				}

			}
			return result;
		}

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
