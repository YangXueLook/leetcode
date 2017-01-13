public class CompareVersionNumbers {

	public static int compareVersion(String version1, String version2) {

		String[] array1 = version1.split("\\.");
		String[] array2 = version2.split("\\.");
		
		System.out.println(array1.length);
		int i1 = 0;
		int i2 = 0;

		while (i1 < array1.length && i2 < array2.length) {
			System.out.println(array1[i1]+" array1[i1]");
			System.out.println(array2[i2]+" array2[i2]");
			
			
			if (Integer.parseInt(array1[i1]) > Integer.parseInt(array2[i2]))
				return 1;
			else if (Integer.parseInt(array1[i1]) < Integer
					.parseInt(array2[i2]))
				return -1;
			i1++;
			i2++;
		}
		if (i1 == array1.length && i2 == array2.length)
			return 0;
		else if (i1 == array1.length)
		{
			for(int i = i2; i< array2.length; i++)
			{
				if( Integer.parseInt(array2[i]) != 0)
					return -1;
			}
			
			return 0;
		}
			
		else
		{
			for(int i = i1; i< array1.length; i++)
			{
				if( Integer.parseInt(array1[i]) != 0)
					return 1;
			}
			
			return 0;
		}
			

	}

	public static void main(String[] args) {
		
//		System.out.println(Integer.parseInt("0"));
		
		System.out.println(compareVersion("1","0"));

	}

}
