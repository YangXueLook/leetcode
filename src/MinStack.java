import java.util.Stack;

public class MinStack {

	private Stack<Integer> stack = new Stack<Integer>();

	private Stack<Integer> minStack = new Stack<Integer>();

	public void push(int x) {
		stack.add(x);

		if (minStack.isEmpty() || x < minStack.peek()) {
			minStack.add(x);
		}

	}

	public void pop() {
		int value = stack.pop();
		if (minStack.peek() == value)
			minStack.pop();
	}

	public int top() {
		return stack.peek();

	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
