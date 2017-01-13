import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}

		intervals.add(newInterval);

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start < o2.start)
					return -1;
				else if (o1.start > o2.start)
					return 1;
				else
					return 0;
			}
		});
		int currentStart = intervals.get(0).start;

		int currentEnd = intervals.get(0).end;

		for (int i = 1; i < intervals.size(); i++) {
			if (currentEnd < intervals.get(i).start) {
				currentStart = intervals.get(i).start;
				currentEnd = intervals.get(i).end;
			} else if (currentEnd >= intervals.get(i).start
					&& currentEnd < intervals.get(i).end) {
				currentEnd = intervals.get(i).end;
				intervals.get(i).start = currentStart;
				intervals.remove(i - 1);
				i--;

			} else if (currentEnd >= intervals.get(i).end) {
				intervals.remove(i);
				i--;
			}

		}

		return intervals;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}