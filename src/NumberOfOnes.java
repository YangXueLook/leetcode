public class NumberOfOnes {

	// 计算一个数有多少位
	int num_of_bits(int n) {
		int k = 0; // 初始为0位
		for (int m = n; m > 0; m /= 10)
			k++;
		return k;
	}

	// 得到一个数n的第i位的数字。最低位为第0位
	int number_of(int n, int i) {
		int num = num_of_bits(n);
		if (i < 0 || i > (num - 1))
			return 0;
		return ((int) (n / Math.pow(10, num - i - 1)));
	}

	// 从0到n的所有整数中1数字出现的次数
	// 实现方案1：直接利用数n每个位上的归纳算出1出现的个数
	int count_From_One_1(int n) {
		// 位数
		int num = num_of_bits(n);
		
		// 跨度
		int scale = (int) Math.pow(10, num - 1);
		
		// 商
		int quotient = 0;
		
		// 余数
		int remainder = 0;
		
		// 某一位的数的大小。
		int bit = 0;// 初始为0
		int count = 0; // 计数

		for (int i = 0; i < num; i++) {
			count += quotient * scale;
			bit = number_of(n, i);
			if (bit > 1)
				count += scale;
			else if (bit == 1) {
				if (i == num - 1)
					remainder = 1;
				else
					remainder = n % scale + 1;
				count += remainder;
			}
			quotient = (int) (n / scale);
			scale /= 10;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
