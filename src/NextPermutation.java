public class NextPermutation {

	public void swap(int num[], int i, int j) {
		num[i] = num[i] + num[j];
		num[j] = num[i] - num[j];
		num[i] = num[i] - num[j];
	}

	public void reverse(int num[], int i, int j) {

		while (i < j) {
			swap(num, i, j);
			i++;
			j--;
		}

	}

	public void nextPermutation(int[] num) {

		if (num.length == 0 || num.length == 1)
			return;

		int length = num.length;

		int currentMinValue = num[length - 1];

		int currentMinPosition = length - 1;

		int i = length - 2;
		for (i = length - 2; i >= 0; i--) {
			if (num[i] < num[i + 1]) {
				break;
			}

		}

		if (i < 0) {
			reverse(num, 0, length - 1);
			return;
		}

		int distance = Integer.MAX_VALUE;
		for (int j = length - 1; j > i; j--) {

			if (num[j] - num[i] > 0 && num[j] - num[i] < distance) {
				currentMinPosition = j;
				distance = num[j] - num[i];
			}

		}

		swap(num, i, currentMinPosition);
		i++;
		System.out.println(i);
		System.out.println(num[0]);
		System.out.println(num[1]);
		reverse(num, i, length - 1);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation n = new NextPermutation();
		int[] num = new int[] { 1, 3, 2 };
		n.nextPermutation(num);

		for (int i = 0; i < num.length; i++)
			System.out.println(num[i]);

	}

}
