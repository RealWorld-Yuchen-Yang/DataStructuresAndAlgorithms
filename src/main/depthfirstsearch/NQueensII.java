package main.depthfirstsearch;

/**
 * Return the total number of distinct solutions of NQueen problem
 * @author yuchenyang
 *
 */
public class NQueensII
{
	private static int count;
	
	public static int totalNQueens(int n)
	{
		count = 0;
		int[] positions = new int[n];
		dfs(positions, 0);
		return count;
	}
	
	private static void dfs(int[] positions, int row)
	{
		final int n = positions.length;
		if(row == n)
		{
			count++;
			return;
		}
		
		for(int j=0; j<n; j++)
		{
			final boolean safe = isSafe(positions, row, j);
			if(!safe)
			{
				continue;
			}
			positions[row] = j;
			dfs(positions, row+1);
		}
	}
	
	private static boolean isSafe(int[] positions, int row, int col)
	{
		for(int i=0; i<row; i++)
		{
			if(positions[i] == col
			|| Math.abs(i-row) == Math.abs(positions[i]-col))
			{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		int inputN = 4;
		System.out.println(totalNQueens(inputN));
	}
}
