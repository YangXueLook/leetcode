
public class RangeBitwiseAND {
	public static int BitLength (int n)
	{
	    int c = 0 ;  // counter
	    while (n != 0)
	    {
	        ++c ;
	        n >>= 1 ;
	    }
	    return c ;
	}
	
	public static int rangeBitwiseAnd(int m, int n) {
		if(m == 0)
			return 0;
		if(m == n)
			return n;
		int power = (int) (Math.log(n)/Math.log(2));
		int mask = (int) Math.pow(2, power);
		int leadingOneNumber = 0;
		
//		System.out.println("mask "+mask);
		int orgLength = BitLength(n);
		
		while(mask < m)
		{
			m = m - mask;
			n = n - mask;
			mask = mask/2;
			leadingOneNumber++;
		}
		
		System.out.println("m "+m);
		System.out.println("n "+n);
		System.out.println("mask "+mask);
		System.out.println("leadingOneNumber "+leadingOneNumber);
		
		int length = orgLength - leadingOneNumber;
		
		int head = (int) (Math.pow(2, leadingOneNumber) - 1);
		if(mask > m)
		{
		
//			System.out.println("length"+length);
			
			head = head << length;
			
			return head;	
		}
		else
		{
			
			
			head = head << length;
			head = head + m;
			
			return head;
		}
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(rangeBitwiseAnd(68,125));

	}

}
