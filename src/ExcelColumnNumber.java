public class ExcelColumnNumber {

	public static int titleToNumber(String s) {
		int result = 0;
		char[] charArray = s.toCharArray();
		int currentNumber;
		for(int i = 0; i < charArray.length; i++)
		{
			result = result * 26;
			currentNumber = charArray[i] - 'A' + 1;
			result = result + currentNumber;
		}
		

		return result;
	}

	public static void main(String[] args) {
		System.out.println(titleToNumber("AB"));

	}

}
