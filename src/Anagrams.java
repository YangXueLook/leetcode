import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Anagrams {

	public List<String> anagrams(String[] strs) {

		ArrayList<String> result = new ArrayList<String>();

		HashMap<String, ArrayList<Integer>> stringAndIndexMap = new HashMap<String, ArrayList<Integer>>();

		String temp;

		for (int i = 0; i < strs.length; i++) {
			temp = strs[i];
			char[] charArray = temp.toCharArray();

			Arrays.sort(charArray);
			
			temp = String.valueOf(charArray);

			if (!stringAndIndexMap.containsKey(temp)) {
				ArrayList<Integer> newEntry = new ArrayList<Integer>();
				newEntry.add(i);
				stringAndIndexMap.put(temp, newEntry);
			} else {
				stringAndIndexMap.get(temp).add(i);
			}

		}
		String key;
		ArrayList<Integer> tempArray;

		Iterator i = stringAndIndexMap.keySet().iterator();

		while (i.hasNext()) {
			key = (String) i.next();
			tempArray = stringAndIndexMap.get(key);
			if (tempArray.size() > 1) {
				for (int j = 0; j < tempArray.size(); j++) {
					result.add(strs[tempArray.get(j)]);
				}
			}

		}

		return result;
	}

	public static void main(String[] args) {
		String a = "a";
		char[] array = a.toCharArray();
		System.out.println(array.length);
		System.out.println(String.valueOf(array));
	}

}
