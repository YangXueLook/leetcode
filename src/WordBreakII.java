import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	public static List<String> wordBreak(String s, Set<String> dict) {

		boolean[] resultArray = new boolean[s.length()];
		for (int i = 0; i < resultArray.length; i++)
			resultArray[i] = false;
		Assistant[] assitantArray = new Assistant[s.length()];
		for (int i = 0; i < resultArray.length; i++)
			assitantArray[i] = new Assistant();

		for (int i = 0; i < resultArray.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 && dict.contains(s.substring(j, i + 1))) {
					resultArray[i] = true;
					ArrayList<String> temp = new ArrayList<String>();
					temp.add(s.substring(j, i + 1));

					assitantArray[i].aa.add(temp);

				} else if (dict.contains(s.substring(j, i + 1))
						&& resultArray[j - 1]) {
					resultArray[i] = true;

					ArrayList<ArrayList<String>> previousResultAA = (ArrayList<ArrayList<String>>) assitantArray[j - 1].aa
							.clone();

					for (int k = 0; k < previousResultAA.size(); k++) {
						ArrayList<String> temp = previousResultAA.get(k);
						temp.add(s.substring(j, i + 1));
						assitantArray[i].aa.add(temp);
					}

				}
			}

		}
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<ArrayList<String>> lastAA = assitantArray[s.length() - 1].aa;

		for (int i = 0; i < lastAA.size(); i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < lastAA.get(i).size(); j++) {
//				System.out.println(lastAA.get(i) + " " + i + " " + j);

				if (j == 0)
					sb.append(lastAA.get(i).get(j));
				else
					sb.append(" " + lastAA.get(i).get(j));
			}
			result.add(sb.toString());

		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		 HashSet<String> set = new HashSet<String>();
		 set.add("a");
		 set.add("aa");
		 set.add("aaa");
		 set.add("aaaa");
		 set.add("aaaaa");
		 set.add("aaaaaa");
		 set.add("aaaaaaa");
		 set.add("aaaaaaaa");
		 set.add("aaaaaaaaa");
		 set.add("aaaaaaaaaa");

		// String s = "leetcode";
		// HashSet<String> set = new HashSet<String>();
		// set.add("leet");
		// set.add("code");

		ArrayList<String> result = (ArrayList<String>) wordBreak(s, set);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

	}

}

class Assistant {
	public ArrayList<ArrayList<String>> aa;

	Assistant() {
		this.aa = new ArrayList<ArrayList<String>>();
	}

}
