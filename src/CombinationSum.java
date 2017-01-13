import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class CombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		Arrays.sort(candidates);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Stack<Integer> path = new Stack<Integer>();
		combinationSum(candidates, target, 0, path, result);
		return result;
	}

	private void combinationSum(int[] arr, int target, int start,
			Stack<Integer> path, ArrayList<ArrayList<Integer>> result) {
		if (target == 0) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.addAll(path);
			result.add(list);
			return;
		}
		for (int i = start; i < arr.length; i++) {
			if (arr[i] > target) // 这时候break可以保证不要再查后面那些越来越大的
				return;
			path.push(arr[i]);
			combinationSum(arr, target - arr[i], i, path, result); // start永远不会越界，所以一开始不用check
			path.pop();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum t = new CombinationSum();
		int[] candidates = new int[] { 2, 3, 6, 7 };

		int target = 7;
		ArrayList<ArrayList<Integer>> result = t.combinationSum(candidates,
				target);

		for (int i = 0; i < result.size(); i++) {
			System.out.println();
			for (int j = 0; j < result.get(i).size(); j++)
				System.out.print(result.get(i).get(j));
		}

	}

}
