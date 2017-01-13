import java.math.BigInteger;

public class SuperPower {
	public int superPow(int a, int[] b) {
		return superPow(a, b, b.length, 1337);
	}

	private int superPow(int a, int[] b, int length, int k) {
		if (length == 1) {
			return powMod(a, b[0], k);
		}

		return (powMod(superPow(a, b, length - 1, k), 10, k)
				* powMod(a, b[length - 1], k)) % k;
	}

	// x^y mod k
	private int powMod(int x, int y, int k) {
		x %= k;
		int pow = 1;
		for (int i = 0; i < y; i++) {
			pow = (pow * x) % k;
		}
		return pow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SuperPower t = new SuperPower();
		System.out.println(t.superPow(2, new int[] { 1, 0, 0, 0, 0, 0, 0, 0 }));

	}

}
