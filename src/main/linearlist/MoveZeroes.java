package main.linearlist;

/**
 * Problem: 
 * 	Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order
 * 	of the non-zero elements
 * 
 * Note: 
 * 	1. You must do this in-place without making a copy of the array
 * 	2. Minimize the total number of operations
 * 
 * Analysis:
 * 	The problem's solution is similar to RemoveElements:
 * 	which is to remove 0s and then add 0s at the end of the array
 * 
 * @author yuchenyang
 *
 */
public class MoveZeroes
{	
	public static void moveZeros(int[] nums)
	{
		int index = 0;
		for(int i=0; i<nums.length; i++)
		{
			if(nums[i]!=0)
			{
				nums[index++] = nums[i];
			}
		}
		for(int i=index; i<nums.length; i++)
		{
			nums[i] = 0;
		}
	}
}
