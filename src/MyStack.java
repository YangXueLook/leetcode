import java.util.LinkedList;
import java.util.Queue;


public class MyStack {
	
	LinkedList<Integer> queue1 = new LinkedList<Integer>();
	LinkedList<Integer> queue2 = new LinkedList<Integer>();
	LinkedList<Integer> currentQueue = queue1;
	
	// Push element x onto stack.
    public void push(int x) {
    	currentQueue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
    	if(currentQueue.size() == 0)
    		return;
    	
    	if(currentQueue == queue1)
    	{
    		while(currentQueue.size() != 1)
    		{
    			queue2.add(currentQueue.poll());
    		}
    		currentQueue.poll();
    		currentQueue = queue2;
    	}
    	else
    	{
    		while(currentQueue.size() != 1)
    		{
    			queue1.add(currentQueue.poll());
    		}
    		currentQueue.poll();
    		currentQueue = queue1;
    	}
        
    }

    // Get the top element.
    public int top() {
    	
    	if(currentQueue.size() == 0)
    		return 0;
    	
    	if(currentQueue == queue1)
    	{
//    		queue2.clear();
    		while(currentQueue.size() != 1)
    		{
    			queue2.add(currentQueue.poll());
    		}
    		int result = currentQueue.poll();
    		currentQueue = queue2;
    		queue2.add(result);
    		return result;
    	}
    	else
    	{
    		while(currentQueue.size() != 1)
    		{
    			queue1.add(currentQueue.poll());
    		}
    		int result = currentQueue.poll();
    		currentQueue = queue1;
    		return result;
    	}
        
    }

    // Return whether the stack is empty.
    public boolean empty() {
    	return currentQueue.isEmpty();
        
    }

	public static void main(String[] args) {
		MyStack s = new MyStack();
		s.push(1);
		s.top();

	}

}
