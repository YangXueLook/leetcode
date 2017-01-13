public class ValidNumber {

	public boolean isNumber(String s) {
		if (s == null || s.length() == 0)
			return false;

		s = s.trim();
		boolean meetDot = false;
		boolean meetE = false;

		char currentChar;
		for (int i = 0; i < s.length(); i++) {
			currentChar = s.charAt(i);

			switch (currentChar) {
			case '+':
			case '-':
				if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
					return false;
				if (i == s.length() - 1)
					return false;
				if (s.charAt(i + 1) > '9' || s.charAt(i + 1) < '0')
					return false;
				break;
			case '.':
				
				if (meetE)
					return false;
				if (meetDot)
					return false;
				if(i == 0)
				{
					if(i == s.length() - 1)
						return false;
					if(s.charAt(i + 1) > '9' || s.charAt(i + 1) < '0')
						return false;
				}
				
				else if(i == s.length() - 1)
				{
					if(s.charAt(i - 1) > '9' || s.charAt(i - 1) < '0')
						return false;
				}
				else
				{
					if (s.charAt(i + 1) > '9' || s.charAt(i + 1) < '0')
						return false;
					if (s.charAt(i - 1) != 'e'&& s.charAt(i - 1) != 'E'&&(s.charAt(i - 1) > '9' || s.charAt(i - 1) < '0'))
						return false;
				}
				

				meetDot = true;
				break;
			case 'e':
			case 'E':
				if (i == 0 || i == s.length() - 1)
					return false;
				if (meetE)
					return false;
				if (s.charAt(i + 1) > '9' || s.charAt(i + 1) < '0')
					return false;
				if (s.charAt(i - 1) > '9' || s.charAt(i - 1) < '0')
					return false;
				meetE = true;
				break;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				break;

			default:
				return false;

			}

		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
