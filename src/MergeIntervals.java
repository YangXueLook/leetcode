import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {

		if (intervals.size() == 0 || intervals.size() == 1) {
			return intervals;
		}

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
