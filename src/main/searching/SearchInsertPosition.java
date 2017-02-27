package main.searching;

/**
 * Given a sorted array and a target value,
 * return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * 
 * Analysis:
 * 	this is just finding the lowerBound of the given target
 * @author yuchenyang
 *
 */
public class SearchInsertPosition
{
	public static int searchInsert(int[] nums, int target)
	{
		return lowerBound(nums, 0, nums.length, target);
	}
	
	private static int lowerBound(int[] nums, int first, int last, int target)
	{
		int mid = first + (last - first)/2;
		while(first<last)
		{
			if(target > nums[mid])
			{
				first = ++mid;
			}
			else
			{
				last = mid;
			}
		}
		return first;
	}
}
