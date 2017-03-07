package main.linearlist;

/**
 * Problem: 
 * You are given an n*n 2D matrix representing an image
 * Rotate the image by 90 degree(clockwise)
 * 
 * Analysis: 
 * 	This is all about find the regularity
 * 	Step1: swap elements according to the minor diagonal(bottomLeft-->topRight)
 *  Step2: swap according to the horizontal middle line
 * 
 * @author yuchenyang
 *
 */
public class RotateImage
{
	public static void rotate(final int[][] matrix)
	{
		final int n = matrix.length;
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n-i; j++)
			{
				//swap according
				swap(matrix, i, j, n-1-j, n-1-i);
			}
		}
		for(int i=0; i<n/2; i++)
		{
			for(int j=0; j<n;j++)
			{
				swap(matrix, i, j, n-1-i, j);
			}
		}
	}
	
	private static void swap(final int[][] matrix, int i, int j, int p, int q)
	{
		int tmp = matrix[i][j];
		matrix[i][j]=matrix[p][q];
		matrix[p][q]=tmp;
	}
}
