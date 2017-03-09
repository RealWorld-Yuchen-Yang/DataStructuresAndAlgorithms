package main.linearlist;

import java.util.Arrays;

/**
 * Problem
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array.
 * And it should return false if every element is distinct
 * 
 * Analysis: 
 * 	step1: sort the array
 * 	step2: iterate through the array
 * 			if two consecutive elements are found to be the same means duplicate exists
 * @author yuchenyang
 *
 */
public class ContainsDuplicate
{	
	public static boolean containsDuplicate(int[] nums)
	{
		Arrays.sort(nums);
		//note: here i starts from 1
		for(int i=1; i<nums.length; i++)
		{
			if(nums[i-1] == nums[i])
			{
				return true;
			}
		}
		return false;
	}
}
