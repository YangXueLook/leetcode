public class PlusOne {

	public int[] plusOne(int[] digits) {

		boolean allNine = true;
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != 9) {
				allNine = false;
				break;
			}
		}
		if (allNine) {
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			for (int i = 1; i < result.length; i++) {
				result[i] = 0;
			}

			return result;
		} else {

			
			if (digits[digits.length - 1] != 9) {
				digits[digits.length - 1] = digits[digits.length - 1] + 1;
				return digits;
			} else {

				digits[digits.length - 1] = 0;
				for (int i = digits.length - 2; i >= 0; i--) {
					if (digits[i] == 9) {
						digits[i] = 0;
					} else {

						digits[i] = digits[i] + 1;
						break;
					}

				}
				return digits;

			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
