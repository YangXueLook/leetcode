import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;



public class LargestPossibleCombinationNumber {

	public static void main(String[] args) {
		int[] array = new int[]{2, 3, 5, 78};
		
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i : array)
			list.add(i);
		
		Collections.sort(list, new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				
				
				
				String s1 = String.valueOf(o1);
				String s2 = String.valueOf(o2);
				if(s1.length() > s2.length())
				{
					String temp = s2;
					s2 = s1;
					s1 = s2;
				}
				
				if(s2.startsWith(s1))
				{
					String tail = s2.substring(s1.length());
				}
				
				
				int i = 0;
				
				for(i = 0; i < Math.min(s1.length(), s2.length()); i++)
				{
					
				}
				
				
				return 0;
			}
			
		});

	}

}

