public class NumberOfOnes {

	// ����һ�����ж���λ
	int num_of_bits(int n) {
		int k = 0; // ��ʼΪ0λ
		for (int m = n; m > 0; m /= 10)
			k++;
		return k;
	}

	// �õ�һ����n�ĵ�iλ�����֡����λΪ��0λ
	int number_of(int n, int i) {
		int num = num_of_bits(n);
		if (i < 0 || i > (num - 1))
			return 0;
		return ((int) (n / Math.pow(10, num - i - 1)));
	}

	// ��0��n������������1���ֳ��ֵĴ���
	// ʵ�ַ���1��ֱ��������nÿ��λ�ϵĹ������1���ֵĸ���
	int count_From_One_1(int n) {
		// λ��
		int num = num_of_bits(n);
		
		// ���
		int scale = (int) Math.pow(10, num - 1);
		
		// ��
		int quotient = 0;
		
		// ����
		int remainder = 0;
		
		// ĳһλ�����Ĵ�С��
		int bit = 0;// ��ʼΪ0
		int count = 0; // ����

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
