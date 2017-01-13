import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SkylineAnswer {

	public List<int[]> getSkyline(int[][] buildings) {
		if (buildings == null || buildings.length == 0) {
			return Collections.emptyList();
		}

		final PriorityQueue<Building> endings = new PriorityQueue<Building>(
				buildings.length, new Comparator<Building>() {

					@Override
					public int compare(Building o1, Building o2) {
						// TODO Auto-generated method stub
						return o1.to - o2.to;
					}
				});

		final PriorityQueue<Integer> heights = new PriorityQueue<Integer>(
				buildings.length, new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						// TODO Auto-generated method stub
						return o2 - o1;
					}

				});

		final List<int[]> result = new ArrayList<>();

		// iterate over each of the building
		for (int[] build : buildings) {
			final Building building = new Building(build);

			while (endings.size() > 0 && endings.peek().to < building.from) {
				removeBuildings(endings, heights, result);
			}

			if (heights.size() == 0 || building.height > heights.peek()) {
				result.add(new int[] { building.from, building.height });
			}
			heights.add(building.height);
			endings.add(building);
		}

		while (endings.size() > 0) {
			removeBuildings(endings, heights, result);
		}

		return result;
	}

	private void removeBuildings(PriorityQueue<Building> endings,
			PriorityQueue<Integer> heights, List<int[]> result) {
		final Building rm = endings.poll();
		heights.remove(rm.height);
		while (endings.size() > 0 && endings.peek().to == rm.to) {
			endings.poll();
			heights.poll();
		}
		final int peek = heights.size() > 0 ? heights.peek() : 0;
		if (peek < rm.height) {
			result.add(new int[] { rm.to, peek });
		}
	}

	private static class Building {
		private final int from;
		private final int to;
		private final int height;

		public Building(int[] building) {
			this.from = building[0];
			this.to = building[1];
			this.height = building[2];
		}
	}

	public static void main(String[] args) {
		
		
		int[][] buildings = new int[][]{ {2 ,9 ,10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8} };
		SkylineAnswer t = new SkylineAnswer();
		List<int[]> result = t.getSkyline(buildings);
		for(int i = 0; i < result.size(); i++)
		{
			System.out.println(result.get(i)[0]+"\t"+result.get(i)[1]);
		}

	}

}
