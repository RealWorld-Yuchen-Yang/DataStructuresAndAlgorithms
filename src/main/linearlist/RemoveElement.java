package main.linearlist;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length. 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length. 
 * 
 * @author yuchenyang
 *
 */
public class RemoveElement
{
	//time complexity O(n), Space complexity O(1)
	public static int removeElement(int[] nums, int target)
	{
		int index = 0;
		for(int i=0; i<nums.length; i++)
		{
			/*
			 * indexPointer moves slower than iPointer,
			 * it stores values do not equal to target 
			 */
			nums[index++]=nums[i];
		}
		return index;
	}
}
