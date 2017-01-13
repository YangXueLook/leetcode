import java.util.HashMap;


public class HitCounter {
	int current = 0;
	HashMap<Integer, Integer> timeAndCountMap;
	
	/** Initialize your data structure here. */
    public HitCounter() {
        this.timeAndCountMap = new HashMap<Integer, Integer>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
