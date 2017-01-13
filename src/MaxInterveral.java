import java.util.Arrays;
import java.util.Comparator;

public class MaxInterveral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StartAndEndPair[] arraySortedByStart = new StartAndEndPair[] {
				new StartAndEndPair(5, 11), new StartAndEndPair(6, 18),
				new StartAndEndPair(2, 5), new StartAndEndPair(3, 12) };
		
		Arrays.sort(arraySortedByStart, new Comparator<StartAndEndPair>(){

			@Override
			public int compare(StartAndEndPair o1, StartAndEndPair o2) {
				return o1.start - o2.start;
				  
			}});
		
		
		StartAndEndPair[] arraySortedByEnd = new StartAndEndPair[arraySortedByStart.length];
		
		for(int i = 0; i < arraySortedByStart.length; i++)
			arraySortedByEnd[i] = arraySortedByStart[i];
		
		
		Arrays.sort(arraySortedByEnd, new Comparator<StartAndEndPair>(){

			@Override
			public int compare(StartAndEndPair o1, StartAndEndPair o2) {
				return o1.end - o2.end;
				  
			}});
		
		
		int currentStartIndex = 0;
		int currentEndIndex = 0;
		
		int resultLeftBound = 0;
		int resultRightBound = 0;
		
		int currentOverlapCount = 1;//至少是一个overlap
		int maxOverlapCount = Integer.MIN_VALUE;
		
		while(currentStartIndex < arraySortedByStart.length && currentEndIndex < arraySortedByEnd.length)
		{
			if(arraySortedByStart[currentStartIndex].start < arraySortedByEnd[currentEndIndex].end)
			{
				
				if(currentOverlapCount > maxOverlapCount)
				{
					maxOverlapCount = currentOverlapCount;
					resultLeftBound = arraySortedByStart[currentStartIndex].start;
					resultRightBound = arraySortedByEnd[currentEndIndex].end;
				}
				currentStartIndex++;
				currentOverlapCount++;
				
			}
			else
			{
				currentEndIndex++;
				currentOverlapCount--;
				
			}
		}
		
		System.out.println(maxOverlapCount+"\t"+resultLeftBound+"\t"+resultRightBound);
		
	}

}

class StartAndEndPair {
	int start = 0;
	int end = 0;

	StartAndEndPair(int start, int end) {
		this.start = start;
		this.end = end;
	}

}