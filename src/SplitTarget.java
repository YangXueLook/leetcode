import java.util.ArrayList;


public class SplitTarget {
	
	public static boolean canGetTarget(int[] array, int target)
	{
		ArrayList<ArrayList<String>> allPossibleSplit = helper(array, 0);
		
		for(ArrayList<String> list: allPossibleSplit)
		{
			int sum = 0;
			for(String i: list)
			{
				sum = sum + Integer.valueOf(i);
				System.out.print(i+"\t");
			}
			
			if(sum == target)
				return true;
			
			System.out.println();
		}
		
		return false;
	}
	

	private static ArrayList<ArrayList<String>> helper(int[] array, int i) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		if(i == array.length - 1)
		{
			ArrayList<String> tempArrayList = new ArrayList<String>();
			tempArrayList.add(String.valueOf(array[i]));
			result.add(tempArrayList);
			return result;
		}
		else
		{
			ArrayList<ArrayList<String>> tempResult = helper(array, i + 1);
			for(ArrayList<String> list: tempResult)
			{
				ArrayList<String> copyList = new ArrayList<String>();
				copyList.addAll(list);
				
				list.add(0, String.valueOf(array[i]));
				copyList.set(0, String.valueOf(array[i]) + (copyList.get(0)));
				
				result.add(list);
				result.add(copyList);
			}
		}
		
		return result;
	}




	public static void main(String[] args) {
		System.out.println(canGetTarget(new int[]{1,5,0,6}, 21));

	}

}
