package main.linearlist;

/**
 * What if duplicates are allowed at most twice?
 * 
 * Analysis: 
 * Since the given array is sorted,
 * we can directly compare the current item with the items 2 step from it
 * since the middle item either equal or greater than it. 
 * and will not affect final result 
 * @author yuchenyang
 *
 */
public class RemoveDuplicatesFromSortedArrayII
{
	public static int removeDuplicateII(int[] nums)
	{
		assert nums != null;
		if(nums.length<2)
		{
			return nums.length;
		}
		
		int index = 2;
		for(int i=2; i<nums.length; i++)
		{
			if(nums[i] != nums[index-2])
			{
				nums[index++]=nums[i];
			}
		}
		return index;
	}
}
