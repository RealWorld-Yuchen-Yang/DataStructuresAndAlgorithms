package main.searching;

/**
 * Problem: 
 *  Follow up for "Search in Rotated Array":
 *  What if "duplicates" are allowed?
 * 
 *  Would this affect the run-time complexity? 
 *  How and Why?
 *  Write a function to determine if a given target is in the array
 * 
 * Analysis: 
 * 	1. If duplicates exists, nums[left, mid] may not be increasing
 * 	   for it may be "left == mid"
 *     Solution is to arbitrarily increase left: that is left++
 *  2. The above approach will affect run-time
 *     Assuming worst case: the target is the smallest and only different element in the array
 *     we will find it in linear time
 *  3. Time complexity is O(n), worse than no duplication's O(logn)
 *  
 * @author yuchenyang
 *
 */
public class SearchInRotatedSortedArrayII
{
	// Time Complexity: O(n)，Space Complexity: O(1)
	public static boolean search(int[] nums, int target) 
	{
        int first = 0;
        int last = nums.length;
        while (first != last) 
        {
            final int mid = first  + (last - first) / 2;
            //found in this iteration
            if (nums[mid] == target)
            {
                return true;
            }
            
            //not found in this iteration
            if (nums[first] < nums[mid])//consistently increasing in front half
            {
                if (nums[first] <= target && target < nums[mid])//binary search
                {
                    last = mid;
                }
                else
                {
                    first = mid + 1;
                }
            }
            else if (nums[first] > nums[mid])//consistently increasing in back half
            {
                if (nums[mid] < target && target <= nums[last-1])//binary search
                {
                	first = mid + 1;
                }
                else
                {
                    last = mid;
                }
            } 
            else
            {
                //skip duplicate one
                first++;
            }
        }
        return false;
    }
}
