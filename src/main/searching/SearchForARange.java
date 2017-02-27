package main.searching;

/*
 * Problem: 
 * 	Given a sorted array of integers, 
 * 	find the starting and ending position of a given target value. 
 * 	Your algorithm's runtime complexity must be in the order of O(logn)
 * 	If the target is not found in the array, return [-1, -1]
 *  Example given [5,7,7,8,8,10], target value is 8, return [3,4]
 *  
 * Analysis: 
 * 	Since the array is sorted and time complexity requirement is O(logn)
 *  So we will be using binary search:
 *	which is separate the array into half in each iteration
 *	each found step would be 1
 *	each not-found step would half the array length of that iteration 
 * 	
 */
public class SearchForARange
{
	/**
	 * 
	 * @param nums, is the given sorted array
	 * @param target, the target number that we would like to search for its range
	 * 				  note the range exists because this array accepts elements' duplication
	 *
	 * @return [lowerBound, upperBound] of the target
	 */
	public static int[] binarySearchSolution(int[] nums, int target)
	{
		/*
		 * find the lowerBound and upperBound respectively
		 * 
		 * For binary search of find the lower/upper bound,
		 * we always compare the middle value nums[mid] with the target value
		 * ,then we move the lower/upperBound of the searching range
		 */
		int lowerBound = lowerBound(nums, 0, nums.length, target);
		int upperBound = upperBound(nums, 0, nums.length, target);
		
		if(lowerBound == nums.length || nums[lowerBound] != target)
		{
			return new int[]{-1, -1};
		}
		else
		{
			return new int[]{lowerBound, upperBound-1};
		}
	}
	
	private static int lowerBound(int[] nums, int first, int last, int target)
	{
		while(first < last)
		{
			/*
			 * Note: 
			 * 	this is a better way of finding middle value
			 *  than (last-first)/2, because of rounding problme
			 */
			int mid = first + (last-first)/2;
			if(target>nums[mid])
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
	
	private static int upperBound(int[] nums, int first, int last, int target)
	{
		int mid = first + (last-first)/2;
		while(first < last)
		{
			if(target>=nums[mid])//the "=" condition is the only difference from finding lowerBound
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
