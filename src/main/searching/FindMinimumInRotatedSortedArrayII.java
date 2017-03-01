package main.searching;

/**
 * Follow up for "Find Minimum in Rotated Sorted Array"
 * What if duplicates are allowed. 
 * 
 * Analysis: 
 * We still need to find the pivot, 
 * however, when it comes to nums[mid]==nums[right], 
 * The pivot can be in the front side or in the back side, 
 * so we can not throw either part of these two. 
 * However, we can --right, since it is the pivot's upper bound anyway
 * which have no chance of being the MIN_VALUE
 * 
 * @author yuchenyang
 *
 */
public class FindMinimumInRotatedSortedArrayII
{
	public static int findMin(int[] nums)
	{
		int left = 0;
		int right = nums.length -1;
		while(left<right)
		{
			final int mid = left + (right-left)/2;
			if(nums[mid]<nums[right])
			{
				right = mid;
			}
			else if(nums[mid]>nums[right])
			{
				left = mid+1;
			}
			else
			{
				--right;
			}
		}
		return nums[left];
	}
}
