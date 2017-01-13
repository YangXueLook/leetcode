import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {
		char[] charArray = s.toCharArray();

		Stack<Character> stack = new Stack<Character>();
		char c;

		for (int i = 0; i < charArray.length; i++) {
			c = charArray[i];
			if (!stack.empty()) {
				if ((stack.peek() == '[' && c == ']')
						|| (stack.peek() == '{' && c == '}')
						|| (stack.peek() == '(' && c == ')')) {
					stack.pop();
				} else {
					stack.push(c);
				}
			} else {
				stack.push(c);
			}

		}

		return stack.size() == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
