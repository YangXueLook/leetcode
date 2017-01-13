public class GasStation {

	public int stopsAt(int[] gas, int[] cost) {
		int currentLeftGas = 0;

		for (int i = 0; i < gas.length; i++) {
			currentLeftGas = currentLeftGas + gas[i];
			if (currentLeftGas < cost[i]) {
				return i;
			} else {
				currentLeftGas = currentLeftGas - cost[i];
			}

		}

		return -1;
	}

	public boolean assistant(int[] gas, int[] cost) {
		int currentLeftGas = 0;

		for (int i = 0; i < gas.length; i++) {
			currentLeftGas = currentLeftGas + gas[i];
			if (currentLeftGas < cost[i]) {
				return false;
			} else {
				currentLeftGas = currentLeftGas - cost[i];
			}

		}

		return true;
	}

	public static int[] rotate(int[] a, int offset) {
		int[] result = new int[a.length];
		int resultIndex = 0;
		for (int i = offset; i < a.length; i++) {
			result[resultIndex] = a[i];
			resultIndex++;
		}
		for (int i = 0; i < offset; i++) {
			result[resultIndex] = a[i];
			resultIndex++;
		}

		return result;

	}

	public int canCompleteCircuit(int[] gas, int[] cost) {

		int[] tempGas;
		int[] tempCost;

		for (int offset = 0; offset < gas.length;) {
			tempGas = rotate(gas, offset);
			tempCost = rotate(cost, offset);

			int next = stopsAt(tempGas, tempCost);

			if (next == -1)
				return offset;
			else {
				offset = offset + next + 1;
			}

		
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 5 };
		int[] b = rotate(a, 3);

		for (int i = 0; i < b.length; i++)
			System.out.println(b[i]);

	}

}
