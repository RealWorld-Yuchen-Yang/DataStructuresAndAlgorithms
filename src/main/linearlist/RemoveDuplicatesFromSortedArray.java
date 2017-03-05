package main.linearlist;

/**
 * Given a sorted array, remove the duplicates in place
 * such that each element appear only once and return the new length. 
 * Do not allocate extra space for another array, you must do this in place with constant memory
 * @author yuchenyang
 *
 */
public class RemoveDuplicatesFromSortedArray
{
	public static int removeDuplicate(int[] nums)
	{
		assert nums != null;
		if(nums.length == 0)
		{
			return 0;
		}
		int index = 1;
		for(int i=1; i<nums.length; i++)
		{
			if(nums[i] != nums[index-1])
			{
				/*
				 * if the next element does not equal the current one,
				 * move the current to the next
				 *  
				 */
				nums[index++]=nums[i];
			}
		}
		
		return index;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
