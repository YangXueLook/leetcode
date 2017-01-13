
public class UglyNumber {
	
	 public static int findNthUglyNumber(int n) {
	        int[] uglyNumberArray = new int[n];
	        uglyNumberArray[0] = 1;// 第一个丑数是1
	        int index = 0;
	        int index_2 = 0;
	        int index_3 = 0;
	        int index_5 = 0;
	 
	        while (index < n - 1) {
	            int min = min(uglyNumberArray[index_2] * 2,
	                    uglyNumberArray[index_3] * 3, uglyNumberArray[index_5] * 5);
	            index++;
	            uglyNumberArray[index] = min;
	 
	            /**
	             * 调整索引
	             */
	            if (uglyNumberArray[index_2] * 2 == min) {
	                index_2++;
	            }
	 
	            if (uglyNumberArray[index_3] * 3 == min) {
	                index_3++;
	            }
	 
	            if (uglyNumberArray[index_5] * 5 == min) {
	                index_5++;
	            }
	        }
	 
	        return uglyNumberArray[n - 1];
	    }
	 
	    private static int min(int a, int b, int c) {
	        return min(min(a, b), c);
	    }
	 
	    private static int min(int a, int b) {
	        return a > b ? b : a;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
