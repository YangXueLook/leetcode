public class RemoveDuplicate {

	public static String removeDuplicateLetters(String s) {
		if(s == null || s.length() == 0)
			return "";
		
		int[] numberOfLetters = new int[26];
		for(int i = 0; i < s.length(); i++)
			numberOfLetters[s.charAt(i) - 'a']++;
		
		int indexOfLetterToRemove = 0;
		
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(indexOfLetterToRemove) > s.charAt(i))
				indexOfLetterToRemove = i;
			
			numberOfLetters[s.charAt(i) - 'a']--;
			
			if(numberOfLetters[s.charAt(i) - 'a'] == 0)//the last time s.charAt(i) appears in s, so can not break after this position
				break;
		}
		
		char c = s.charAt(indexOfLetterToRemove);
		
		
		
		return c + removeDuplicateLetters(s.substring(indexOfLetterToRemove + 1).replaceAll(c + "", ""));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicateLetters("bcabc"));

	}

}
