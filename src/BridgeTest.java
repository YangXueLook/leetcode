import java.util.ArrayList;
import java.util.List;

public class BridgeTest {

	private static int[] left;
	private static int[] right;
	private static int counter = 0; // number of solutions
	private static List<String> path = new ArrayList<String>();
	private static List<Integer> time = new ArrayList<Integer>();
	private static int maxTime = Integer.MIN_VALUE;
	private static int minTime = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// I assume the length of people is at least two
		int[] people = new int[] { 1, 2, 5, 10};
		int n = people.length;
		left = new int[n];
		right = new int[n];

		// initialize left and right island
		// -1 means the person is not on the island (e.g., left[i]== -1 means
		// ith person is not on the left island)
		for (int i = 0; i < people.length; i++) {
			left[i] = people[i];
			right[i] = -1;
		}

		findSolution();
		System.out.println("Nummber of solutions: " + counter);
		System.out.println("Maximum time to cross: " + maxTime);
		System.out.println("Minimum time to cross: " + minTime);
	}

	public static void findSolution() {
		for (int i = 0; i < left.length - 1; i++) {
			if (left[i] == -1)
				continue;
			for (int j = i + 1; j < left.length; j++) {
				if (left[j] == -1)
					continue;
				time.add(Math.max(left[i], left[j]));
				removeFromLeft(i, j);
				path.add("->" + i + "," + j);

				if (isEmpty(left)) {
					removeFromRight(i, j);
					counter++;
					updateTime();
					printPath();
					time.remove(time.size() - 1);
					path.remove(path.size() - 1);
					return;
				}
				for (int k = 0; k < right.length; k++) {
					if (right[k] == -1)
						continue;
					time.add(right[k]);
					removeFromRight(k);
					path.add("<-" + k);
					findSolution();
					time.remove(time.size() - 1);
					path.remove(path.size() - 1);
					removeFromLeft(k); // Restore to previous state

				}
				time.remove(time.size() - 1);
				path.remove(path.size() - 1);
				removeFromRight(i, j); // restore to previous state

			}
		}
	}

	// move two people from left island to right island
	public static void removeFromLeft(int i, int j) {
		right[i] = left[i];
		right[j] = left[j];
		left[i] = -1;
		left[j] = -1;
	}

	// move two people from right island to left island
	public static void removeFromRight(int i, int j) {
		left[i] = right[i];
		left[j] = right[j];
		right[i] = -1;
		right[j] = -1;
	}

	// move one person from right island to left island
	public static void removeFromRight(int i) {
		left[i] = right[i];
		right[i] = -1;
	}

	// move one person from left island to right island
	public static void removeFromLeft(int i) {
		right[i] = left[i];
		left[i] = -1;
	}

	// check if island is empty
	public static boolean isEmpty(int[] island) {
		for (int i = 0; i < island.length; i++) {
			if (island[i] != -1)
				return false;
		}
		return true;
	}

	// print out the crossing strategy
	public static void printPath() {
		for (String s : path) {
			System.out.print(s);
		}
		System.out.println();
	}

	// update maxTime and minTime
	public static void updateTime() {
		int sum = 0;
		for (int i : time) {
			sum += i;
		}
		if (sum > maxTime) {
			maxTime = sum;
		}
		if (sum < minTime) {
			minTime = sum;
		}
	}
}