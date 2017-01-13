import java.util.HashMap;
import java.util.Iterator;

public class MajorityElement {
	public int majorityElement(int[] num) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			if (map.containsKey(num[i]))
				map.put(num[i], map.get(num[i]) + 1);
			else
				map.put(num[i], 1);
		}
		int threshold = num.length / 2;

		Iterator i = map.keySet().iterator();
		int result = 0;
		while (i.hasNext()) {
			result = (int) i.next();
			if (map.get(result) > threshold)
				return result;
		}

		return 0;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
