import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArraysII {

	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i: nums1)
		{
			if(map.containsKey(i))
			{
				map.put(i, map.get(i) + 1);
			}
			else
			{
				map.put(i, 1);
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i : nums2)
		{
			if(map.containsKey(i))
			{
				list.add(i);
				if(map.get(i) == 1)
				{
					map.remove(i);
				}
				else
				{
					map.put(i, map.get(i) - 1);
				}
			}
		}
		int[] result = new int[list.size()];
		for(int i = 0; i < list.size(); i++)
		{
			result[i] = list.get(i);
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
