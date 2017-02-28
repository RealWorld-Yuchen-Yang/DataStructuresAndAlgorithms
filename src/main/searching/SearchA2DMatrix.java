package main.searching;

/**
 * Write an efficient algorithm that searches for a value in an 
 * m*n matrix. This matrix has the following properties:
 * 	Integers in each row are sorted from left to right. 
 * 	The first integer of each row is greater than the last integer of the previous row. 
 * 
 * Given a target value, determine if it exists
 * 
 * Analysis: 
 * 	Since each row is increasing, and all elements in row j is greater than row (j-1)
 * 	we can virtualize the matrix as a linear array. 
 * 	And the way of virtualization is to 
 *  just translate the 1D index into 2D indices
 * 
 * 	After the virtualization, we can apply binary search on this new array
 * @author yuchenyang
 *
 */
public class SearchA2DMatrix
{
	public boolean searchMatix(int[][] matrix, int target)
	{
		if(matrix.length == 0) 
		{
			return false; 
		}
		
		final int m = matrix.length;
		final int n = matrix[0].length;
		
		int first = 0;//virtualize 1D array first index
		int last = m*n;//virtualize 1D array last index
		
		while(first<last)
		{
			int mid = first + (last-first)/2;//virtualized middle index
			int value = matrix[mid/n][mid%n];//value in the virtualized middle index
			
			if(value == target)
			{
				return true; 
			}
			else if(value < target)
			{
				first = mid + 1;
			}
			else
			{
				last = mid;
			}
		}
		return false;		
	}
}
