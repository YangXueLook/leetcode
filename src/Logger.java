import java.util.HashMap;


public class Logger {
	private HashMap<String, Integer> map;
	/** Initialize your data structure here. */
    public Logger() {
        this.map = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false. The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
    	if(map.containsKey(message))
    	{
    		if(timestamp - map.get(message) < 10)
    			return false;
    		else
    		{
    			map.put(message, timestamp);
    			return true;
    		}
    	}  
    	else
    	{
    		map.put(message, timestamp);
			return true;
    	}
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
