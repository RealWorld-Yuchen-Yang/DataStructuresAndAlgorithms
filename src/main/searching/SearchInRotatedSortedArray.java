package main.searching;

/**
 * Problem:
 * 	Suppose a sorted array is rotated at some pivot unknown to you beforehand
 * 	i.e. {0,1,2,4,5,6,7} might become {4,5,6,7,0,1,2}
 * 	You are given a target value to search. 
 *  If found in the array, return the index
 *  otherwise return -1
 *  You may assume no duplicate exists in the array
 * 
 * Analysis: 
 * 	Since there is only one pivot, 
 *  half of the array must be consistently increasing
 *  that is: 
 *  	If nums[left]<=nums[mid], the range [left, mid) must be increasing
 *  	Otherwise range (mid, last] must be increasing
 *  We can apply binary search on such range
 *  	
 * @author yuchenyang
 * 
 */
public class SearchInRotatedSortedArray
{
	public static int binarySearchInLeftMidRangeSolution(int[] nums, int target)
	{
		int first = 0;
		int last = nums.length;
		while(first != last)
		{
			final int mid = first + (last - first)/2;
			if(nums[mid] == target)
			{
				return mid;
			}
			if(nums[first]<=nums[mid])//front part of the array is consistently increasing
			{
				if(nums[first]<=target && target<nums[mid])
				{
					last = mid;
				}
				else
				{
					first = mid+1;
				}
			}
			else//end part of the array is consistently increasing
			{
				if(nums[mid]<target && target<=nums[last-1])
				{
					first = mid+1;
				}
				else
				{
					last = mid;
				}
			}
		}
		return -1;
	}
}
