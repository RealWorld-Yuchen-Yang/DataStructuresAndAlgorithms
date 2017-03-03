package main.depthfirstsearch;

import org.junit.Test;

/**
 * Problem:
 * A robot is located at the top-left corner of a m*n grid
 * The robot can only move either down or right at any point in time. 
 * The robot is trying t reach the bottom-right corner of the grid
 * 
 * Analysis: 
 * We need to use dfs+cahce
 * time complexity O(n^2)
 * space complexity O(n^2)
 * 
 * @author yuchenyang
 *
 */
public class UniquePaths
{
	private static int[][] cache;
	
	public static int uniquePaths(int m, int n)
	{
		/*
		 * cache[x][y] represents
		 * #path from currnetPoint(x,y) to startingPoint(0,0)
		 */
		cache = new int[m][n]; 
		cache[0][0]=1;
		return dfs(m-1, n-1);
	}
	
	private static int dfs(int x, int y)
	{
		if(x<0 || y<0)
		{
			//invalid input, terminate
			return 0;
		}
		if(x==0&&y==0)
		{
			//reached starting point, terminate condition
			return cache[0][0];
		}
		if(cache[x][y]>0)//originally cache[x][y] has been initizlized as 0
		{
			return cache[x][y];
		}
		else
		{
			return cache[x][y] = dfs(x-1,y)+dfs(x, y-1);
		}
	}
	
	@Test
	public void uniquePathsTest()
	{
		int m=4;
		int n=3;
		System.out.println(uniquePaths(m, n));
	}
	
}
