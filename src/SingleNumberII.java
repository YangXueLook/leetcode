public class SingleNumberII {
	public static int singleNumber(int[] A) {
		int[] bitArray = new int[32];
		for (int i = 0; i < bitArray.length; i++) {
			bitArray[i] = 0;
		}
		int n = 0;
		String s = "";
		for (int i = 0; i < A.length; i++) {
			n = A[i];
			s = Integer.toBinaryString(n);
			
			for (int j = s.length() - 1; j >= 0; j--) {
				bitArray[31 + (j - s.length() + 1)] = bitArray[31 + (j
						- s.length() + 1)]
						+ Integer.parseInt(Character.toString(s.charAt(j)));
			}

		}

		for (int i = 0; i < bitArray.length; i++) {
			// System.out.println(bitArray[i]);
			bitArray[i] = bitArray[i] % 3;

		}

		if (bitArray[0] == 0) {
			s = "";
			for (int i = 0; i < bitArray.length; i++) {
				s = s + Integer.toString(bitArray[i]);
			}

			return Integer.parseInt(s, 2);
		}

		else {
			s = "";
			for (int i = 1; i < bitArray.length; i++) {
				s = s + Integer.toString(bitArray[i]);
			}
			return Integer.parseInt(s, 2) - Integer.MAX_VALUE - 1;
		}

	}

	public static void main(String[] args) {
		// System.out.println(Integer.parseInt("01111111111111111111111111111110",
		// 2) - Integer.MAX_VALUE);
		//
		// System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
		// System.out.println(Integer.MIN_VALUE);
		// System.out.println(0 - Integer.MAX_VALUE - 1);

		int[] a = new int[] { 1, 2, 3, -5, 1, 2, 3, 1, 2, 3 };

		System.out.println(singleNumber(a));

	}

}
