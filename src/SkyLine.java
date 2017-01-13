import java.util.ArrayList;
import java.util.List;

public class SkyLine {

	public List<int[]> getSkyline(int[][] buildings) {
		int rightMax = 0;
		for(int i = 0; i < buildings.length; i++)
		{
			rightMax = Math.max(rightMax, buildings[i][1]);
		}
		
		int[] maxHeightArray = new int[rightMax + 1];
		
		for(int i = 0; i < buildings.length; i++)
		{
			for(int j = buildings[i][0]; j <= buildings[i][1]; j++)
				maxHeightArray[j] = Math.max(maxHeightArray[j], buildings[i][2]);
		}
		
		for(int i = 0; i < maxHeightArray.length; i++)
			System.out.print(maxHeightArray[i]+"\t");
		System.out.println();
		
		ArrayList<int[]> result = new ArrayList<int[]>();
		if(maxHeightArray[0] != 0)
		{
			int[] temp = new int[2];
			temp[0] = 0;
			temp[1] = maxHeightArray[0];
			result.add(temp);
			
		}
		for(int i = 1; i < maxHeightArray.length - 1; i++)
		{
			if(maxHeightArray[i] > maxHeightArray[i + 1])
			{
				int[] temp = new int[2];
				temp[0] = i;
				temp[1] = maxHeightArray[i + 1];
				result.add(temp);
			}
			if(maxHeightArray[i] < maxHeightArray[i + 1])
			{
				int[] temp = new int[2];
				temp[0] = i + 1;
				temp[1] = maxHeightArray[i + 1];
				result.add(temp);
			}
		}
		
		int[] temp = new int[2];
		temp[0] = maxHeightArray.length - 1;
		temp[1] = 0;
		result.add(temp);

		return result;

	}

	public static void main(String[] args) {
		int[] array =new int[Integer.MAX_VALUE];
		
		int[][] buildings = new int[][]{ {2 ,9 ,10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8} };
		SkyLine t = new SkyLine();
		List<int[]> result = t.getSkyline(buildings);
		for(int i = 0; i < result.size(); i++)
		{
			System.out.println(result.get(i)[0]+"\t"+result.get(i)[1]);
		}

	}

}
