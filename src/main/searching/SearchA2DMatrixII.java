package main.searching;

/**
 * Write an efficient algorithm that searches for a value
 * in an m*n matrix. The matrix has the following properties:
 * 	Integers in each row are sorted in ascending from left to right
 * 	Integers in each column are sorted in ascending from top to bottom. 
 * 
 * Analysis:
 * 	Starting from top-right corner, 
 *  compare target with matrix[i][j].
 *  If target < matrix[i][j], then in the same column, row number <=i will not be applicable
 *  	so i should ++
 *  If target > matrix[i][j], then in the same row, column number >=j will not be applicable
 *  	so j should --
 *  
 *  Time complexity O(m+n), space complexity O(1)
 * @author yuchenyang
 *
 */
public class SearchA2DMatrixII
{
	public static boolean searchMatrix(int[][] matrix, int target)
	{
		if(matrix.length == 0 || matrix[0].length == 0)
		{
			return false;
		}
		
		//i and j together form a top-right corner index
		int i=0;//top row
		int j=matrix[0].length-1;//right row
		
		while(i<matrix.length && j>=0)
		{
			final int x = matrix[i][j];
			if(x==target)
			{
				return true;
			}
			else if(x<target)
			{
				++i;
			}
			else
			{
				--j;
			}
		}
		
		return false;
	}	
}
