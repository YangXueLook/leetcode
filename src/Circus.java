import java.util.Arrays;
import java.util.Comparator;

public class Circus {

	public static void main(String[] args) {
		HeightAndWeight[] array = new HeightAndWeight[] {
				new HeightAndWeight(65, 5), new HeightAndWeight(70, 150),
				new HeightAndWeight(56, 90), new HeightAndWeight(75, 190),
				new HeightAndWeight(60, 95), new HeightAndWeight(68, 110)};

		Arrays.sort(array, new Comparator<HeightAndWeight>(){

//			@Override
			public int compare(HeightAndWeight o1, HeightAndWeight o2) {
				// TODO Auto-generated method stub
				return o1.height - o2.height;
			}
			
		});
		
		for(HeightAndWeight element : array)
		{
			System.out.println(element.height+"\t"+element.weight);
		}
		
		int maxIncreasingWeightLength = 0;
		int startIndex = 0;
		int endIndex = 0;
		
		for(int i = 1; i < array.length; i++)
		{
			if(i == array.length - 1)
			{
				if(array[i].weight > array[i-1].weight)
				{
					maxIncreasingWeightLength = Math.max(maxIncreasingWeightLength, i - startIndex + 1);
				}
				else
				{
					maxIncreasingWeightLength = Math.max(maxIncreasingWeightLength, endIndex - startIndex + 1);
					
				}
			}
			else
			{
				if(array[i].weight > array[i-1].weight)
				{
					endIndex = i;
				}
				else
				{
					maxIncreasingWeightLength = Math.max(maxIncreasingWeightLength, endIndex - startIndex + 1);
					startIndex = i;
				}
			}
			
			
		}
		
		System.out.println(maxIncreasingWeightLength);
	}

}

class HeightAndWeight {
	int height = 0;
	int weight = 0;

	HeightAndWeight(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}
}