import java.util.Scanner;


public class ReadComments {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 5000; i++)
		{
			String s = scan.nextLine();
			if(s.startsWith("//"))
			{
				s = s.replace("//", "");
				System.out.println(s);
			}
			else if(s.startsWith("/*"))
			{
				while(true)
				{
					String s1 = scan.nextLine();
					s = s + s1;
					if(s1.endsWith("*/"))
						break;
				}
				
				s = s.replace("/*", "");
				s = s.replace("*/", "");
				System.out.println(s);
			}
		}

//test 1
/* test2
test3
*/

	}

}
