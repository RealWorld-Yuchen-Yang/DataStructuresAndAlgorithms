package main.searching;

/**
 * Problem: 
 * 	Find the minimum element in a rotated array.
 *  No duplication exists
 *  
 * Analysis: 
 * 	The worst case is go over the array entirely once. 
 * 	The time complexity should be O(n), however we haven't used the characteristic of this array
 * 
 * 	A better approach is to use binary search, and time complexity should be O(logn)
 * 	The key point is to find the pivot(which is the MIN_VALUE)
 * 	if nums[mid] < nums[right], then the pivot should be in the left part
 * 	if nums[mid] > nums[right], then the pivot should be in the right part
 * 	by no means nums[mid] == nums[right], for the array is strictly ascending
 * @author yuchenyang
 *
 */
public class FindMinimumInRotatedSortedArray
{
	public static int findMin(int[] nums)
	{
		int left = 0;
		int right = nums.length -1;
		while(left < right)
		{
			int mid = left + (right-left)/2;
			if(nums[mid]<nums[right])
			{
				right = mid;
			}
			else
			{
				left = mid +1;
			}
		}
		return nums[left];//the last position of left pointer is the pivot
	}
	
	
	
}
