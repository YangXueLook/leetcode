import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class SnakeGame {
	/**
	 * Initialize your data structure here.
	 * 
	 * @param width
	 *            - screen width
	 * @param height
	 *            - screen height
	 * @param food
	 *            - A list of food positions E.g food = [[1,1], [1,0]] means the
	 *            first food is positioned at [1,1], the second is at [1,0].
	 */
//	int[][] matrix;
	int height;
	int width;
	int score = 0;
	int[][] food;
	HashSet<Integer> set = new HashSet<Integer>();
	Deque<int[]> q = new ArrayDeque<int[]>();
	int currentX = 0;
	int currentY = 0;
	int foodIndex = 0;
	int[] currentFood = new int[2];
	
	
	public SnakeGame(int width, int height, int[][] food) {
//		this.matrix = new int[height][width];
		this.height = height;
		this.width = width;
		
		this.food = food;
		q.add(new int[]{0, 0});
		set.add(0);
//		currentFood = food[foodIndex];
	}

	/**
	 * Moves the snake.
	 * 
	 * @param direction
	 *            - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
	 * @return The game's score after the move. Return -1 if game over. Game
	 *         over when snake crosses the screen boundary or bites its body.
	 */
	public int move(String direction) {
		if(foodIndex < food.length)
			currentFood = food[foodIndex];
		else
		{
			currentFood[0] = -1;
			currentFood[1] = -1;
		}
		
		int[] head = q.getFirst();
		int[] nextPosition = new int[2];
		if(direction.equals("U"))
		{
			nextPosition[0] = head[0] - 1;
			nextPosition[1] = head[1];
		}
		else if(direction.equals("D"))
		{
			nextPosition[0] = head[0] + 1;
			nextPosition[1] = head[1];
		}
		else if(direction.equals("L"))
		{
			nextPosition[0] = head[0];
			nextPosition[1] = head[1] - 1;
		}
		else if(direction.equals("R"))
		{
			nextPosition[0] = head[0];
			nextPosition[1] = head[1] + 1;
		}
		
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				
				if(set.contains(i * width + j))
					System.out.print("X");
				else
					System.out.print("O");
			}
			System.out.println();
		}
		
//		System.out.println(nextPosition[0] + "\t" + nextPosition[1]);
		
		if(nextPosition[0] < 0 || nextPosition[0] >= height || nextPosition[1] < 0 || nextPosition[1] >= width)
			return -1;
		
		else if(nextPosition[0] == currentFood[0] && nextPosition[1] == currentFood[1])
		{
			q.addFirst(nextPosition);
//			list.add(0, nextPosition);
			set.add(nextPosition[0] * width + nextPosition[1]);
			foodIndex++;
			score++;
			return score;
			
		}
		else
		{
			int[] tail = q.removeLast();
//					list.remove(list.size() - 1);
			set.remove(tail[0] * width + tail[1]);
			
			if(set.contains(nextPosition[0] * width + nextPosition[1]))
				return -1;
			
			q.addFirst(nextPosition);
			
//			list.add(0, nextPosition);
			set.add(nextPosition[0] * width + nextPosition[1]);
			
			return score;
		}

		

	}

	public static void main(String[] args) {
		
		
		 SnakeGame obj = new SnakeGame(3, 3, new int[][]{{2,0},{0,0},{0,2},{0,1},{2,2},{0,1}});
		 System.out.println(obj.move("D"));
		 System.out.println(obj.move("D"));
		 System.out.println(obj.move("R"));
		 System.out.println(obj.move("U"));
		 System.out.println(obj.move("U"));
		 System.out.println(obj.move("L"));
		 System.out.println(obj.move("D"));
		 System.out.println(obj.move("R"));
		 System.out.println(obj.move("R"));
		 System.out.println(obj.move("U"));
		 System.out.println(obj.move("L"));
		 System.out.println(obj.move("L"));
		 System.out.println(obj.move("D"));
		 System.out.println(obj.move("R"));
		 System.out.println(obj.move("U"));
		
		 
		 
		

	}

}
