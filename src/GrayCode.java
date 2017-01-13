import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	// G(N) = (B(n)/2) XOR B(n)

	public List<Integer> grayCode(int n) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < (int) Math.pow(2, n); i++)
			result.add((i / 2) ^ i);

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
