import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LineReflection {
	public boolean isReflected(int[][] points) {
		if(points == null || points.length == 0)
			return true;
		
		
		HashMap<Integer, HashSet<Integer>> XYMap = new HashMap<Integer, HashSet<Integer>>();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int[] xy : points)
		{
			max = Math.max(max, xy[0]);
			min = Math.min(min, xy[0]);
			if(XYMap.containsKey(xy[0]))
				XYMap.get(xy[0]).add(xy[1]);
			else
			{
				HashSet<Integer> set = new HashSet<Integer>();
				set.add(xy[1]);
				XYMap.put(xy[0], set);
			}
				
		}
		
		
		double mid = (double)(min + max)/2;
		
		for(int[] xy : points)
		{
			int reflectedX = (int) (2 * mid - xy[0]);
			if(!XYMap.containsKey(reflectedX))
				return false;
			if(!XYMap.get(reflectedX).contains(xy[1]))
				return false;
		}
		

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
