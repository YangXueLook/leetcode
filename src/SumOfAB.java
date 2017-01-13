public class SumOfAB {

	public int getSum(int a, int b) {
		if (b == 0)
			return a;
		int carry = (a & b) << 1;
		int sum = a ^ b;
		return getSum(sum, carry);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
