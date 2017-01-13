import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GenerateParentheses {
	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		HashSet<String> s = new HashSet<String>();

		if (n == 0)
			return result;
		if (n == 1) {
			result.add("()");
			return result;
		}
		List<String> previousResult  = generateParenthesis(n-1);
		
		for(int i = 0; i < previousResult.size(); i++)
		{
			
			
			for(int m = 0; m <= 2*(n-1); m++)
			{
				
				for(int mm = m+1; mm <= 2*n-1; mm++)
				{
					StringBuffer temp = new StringBuffer(previousResult.get(i)); 
					temp.insert(m, '(');
					temp.insert(mm, ')');
					s.add(temp.toString());
				}
				
			}
		}
		

		return new ArrayList(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> result = (ArrayList<String>) generateParenthesis(3);
		for(int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
		
//		StringBuffer test = new StringBuffer("()");
//		System.out.println(test.insert(2, '('));
	}

}
