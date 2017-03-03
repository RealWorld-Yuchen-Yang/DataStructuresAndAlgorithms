package main.depthfirstsearch;

import org.junit.Test;

/**
 * Problem: Follow up for Unique Paths Consider if some obstacles are added to
 * the grid. How many unique paths would there be?
 * 
 * obstacle: 1 space: 0
 * 
 * Analysis: This is just UniquePath with some additional terminate condition
 * dfs+cache+specificTerminateCondition
 * 
 * @author yuchenyang
 *
 */
public class UniquePathII
{
	public static int uniquePathsWithObstacles(int[][] obstacleGrid)
	{
		final int m = obstacleGrid.length;
		final int n = obstacleGrid[0].length;
		if (obstacleGrid[0][0] != 0 || obstacleGrid[m - 1][n - 1] != 0)
		{
			// if starting/ending point is occupied by obstacles, no available
			// path
			return 0;
		}

		cache = new int[m][n];// cache cell stores #paths from current(m-1, n-1)
								// to startingPoint(0,0
		cache[0][0] = 1;
		return dfs(obstacleGrid, m - 1, n - 1);
	}

	private static int dfs(int[][] obstacleGrid, int x, int y)
	{
		if (x < 0 || y < 0)
		{
			return 0;
		}

		if (obstacleGrid[x][y] != 0)
		{
			// if current spot is not a space, it is a dead end
			return 0;
		}

		if (x == 0 && y == 0)
		{
			// terminate condition: reached starting point
			return cache[0][0];
		}

		if (cache[x][y] > 0)
		{
			return cache[x][y];// if the point(x, y) was initiazlied before,
								// just return the cached value
		} else
		{
			//this is tail recursion
			return cache[x][y] = dfs(obstacleGrid, x - 1, y) + dfs(obstacleGrid, x, y - 1);
		}

	}

	private static int[][] cache;

	@Test
	public void uniquePathsWithObstaclesTest()
	{
		int[][] gridWithObstacles = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.println(uniquePathsWithObstacles(gridWithObstacles));
	}
}
