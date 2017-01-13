import java.util.Stack;

public class SimplyPath {

	public static String simplifyPath(String path) {
		String[] pathArray = path.split("/");
		if(pathArray.length == 0)
			return "/";
		Stack<String> s = new Stack<String> ();
		for(int i = 0; i < pathArray.length; i++)
		{
			
			if(pathArray[i].equals(".")||pathArray[i].equals(""))
			{
				
			}
			else if(pathArray[i].equals(".."))
			{
				
				if(!s.isEmpty())
					s.pop();
			}
			else
				s.push(pathArray[i]);
		}
		
		String result = "";
		while(!s.isEmpty())
		{
			if(result.length() != 0)
				result = s.pop()+"/"+result; 
			else
				result = s.pop();
		}
			
		result = "/"+result;
		
		return result;
	}

	public static void main(String[] args) {
		String s = "/a/./b/../../c/";
		String [] a = s.split("/");
		
		for(int i = 0; i < a.length; i++)
			System.out.println(a[i].length());
		
		System.out.println(simplifyPath("/../"));

	}

}
