import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SummaryRanges {
	TreeMap<Integer, Interval> map;
	

	public SummaryRanges() {
		map = new TreeMap<Integer, Interval>();
		
	}

	public void addNum(int val) {
		if(map.containsKey(val))
			return;
		Integer low = map.lowerKey(val);
		Integer high = map.higherKey(val);
		if(low != null && high != null && map.get(low).end == val - 1 && map.get(high).start == val + 1)
		{
			map.get(low).end = map.get(high).end;
			map.remove(high);
		}
		else if(low != null && map.get(low).end + 1 >= val)
		{
			map.get(low).end = Math.max(val, map.get(low).end);
		}
		else if(high != null && high - 1 == val)
		{
			map.put(val, new Interval(val, map.get(high).end));
			map.remove(high);
		}
		else
		{
			map.put(val, new Interval(val,val));
		}

	}

	public List<Interval> getIntervals() {
		ArrayList<Interval> result = new ArrayList<Interval>(map.values());
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
