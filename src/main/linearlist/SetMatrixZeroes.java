package main.linearlist;

import java.util.Arrays;

/**
 * Given a m*n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place. 
 * A straight forward solution usign O(mn) space is probably a bad idea
 * A simple inprovement uses O(m+n) space, but still not the best solution
 * @author yuchenyang
 *
 */
public class SetMatrixZeroes
{	
	//space complexity: O(m+n)
	public static void setZeores(int[][] matrix)
	{
		final int m = matrix.length;
		final int n = matrix[0].length;
		boolean[] row = new boolean[m];
		boolean[] col = new boolean[n];
		
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(matrix[i][j]==0)
				{
					row[i] = col[j] = true;
				}
			}
		}
		
		for(int i=0; i<m; i++)
		{
			if(row[i]) Arrays.fill(matrix[i], 0);
		}
		for(int j=0; j<n; j++)
		{
			if(col[j])
			{
				for(int i=0; i<m; i++)
				{
					matrix[i][j] = 0;
				}
			}
		}
	}
}
