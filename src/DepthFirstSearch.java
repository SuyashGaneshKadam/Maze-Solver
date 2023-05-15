import java.util.List;

public class DepthFirstSearch {
	public static boolean searchPath(int[][] maze, int x, int y, List<Integer> path) 
	{
		if(maze[x][y] == 9) 
		{
			//We reached our destination
			path.add(x);
			path.add(y);
			return true;
		}
		if(maze[x][y] == 0) 
		{
			maze[x][y] = 2;                                  //Marking visited
			int dirs[][] = {{0,1},{1,0},{0,-1},{-1,0}};      //To traverse in all 4 directions
			for(int[] dir : dirs) 
			{
				if(searchPath(maze, dir[0]+x, dir[1]+y, path)) 
				{
					path.add(x);
					path.add(y);
					return true;
				}
			}
		}
		return false;
	}
}
