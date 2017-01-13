import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static boolean wordBreak(String s, Set<String> dict) {
		boolean[] resultArray = new boolean[s.length()];
		for (int i = 0; i < resultArray.length; i++)
			resultArray[i] = false;

		for (int i = 0; i < resultArray.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 && dict.contains(s.substring(j, i + 1))) {
					resultArray[i] = true;
					break;
				} else if (dict.contains(s.substring(j, i + 1))
						&& resultArray[j - 1]) {
					resultArray[i] = true;
					break;
				}
			}

		}

		return resultArray[resultArray.length - 1];
	}

	public static void main(String[] args) {
		String s = "leetcode";
		HashSet<String> set = new HashSet<String>();
		set.add("leet");
		set.add("coda");
		System.out.println(s.substring(0, 4));

		System.out.print(wordBreak(s, set));
	}

}
