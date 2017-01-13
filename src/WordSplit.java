import java.util.ArrayList;
import java.util.Arrays;


public class WordSplit {
	public static ArrayList<String> splitSentence(String s)
	{
		s = s.trim().replaceAll(" +", " ");
		
		String[] array = s.split(" ");
		
		for(String st : array)
		{
			System.out.println(st);
		}
		
		ArrayList<String> result = new ArrayList<String>();


		for(int i = 0; i < array.length; i++)
		{
			if(array[i].startsWith("\""))
			{
				String currentString = array[i].replace("\"", "");
				i++;
				while(!array[i].endsWith("\""))
				{
					currentString = currentString +" " + array[i];
					i++;
				}
				currentString = currentString +" " + array[i].replace("\"", "");
//				i++;
				result.add(currentString);
			}
			else
				result.add(array[i]);
		}
		
		for(String st : result)
		{
			System.out.println(st);
		}
		
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		splitSentence(" I        have a \"faux coat\"");

	}

}
