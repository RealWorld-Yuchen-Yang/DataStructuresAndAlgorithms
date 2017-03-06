package main.linearlist;

import java.util.Arrays;

/**
 * Problem: 
 * Given an array of n integers, 
 * find three integers in nums such that sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution
 * 
 * For example, given array nums = {-1, 2, 1, -4}, and target=1
 * The sum that is closest to the target is 2 (-1+2+1=2)
 * 
 * Analysis: 
 * 	we need to 
 * @author yuchenyang
 *
 */
public class ThreeSumClosest
{
	public static int find(int[] nums, int target)
	{
		assert nums!=null;
		int result = 0;
		int minGap = Integer.MAX_VALUE;
		if(nums.length<3)
		{
			return result;
		}
		Arrays.sort(nums);
		for(int i=0;i<nums.length-1; i++)
		{
			int j = i+1;
			int k = nums.length-1;
			while(j<k)
			{
				final int sum = nums[i]+nums[j]+nums[k];
				final int gap = Math.abs(sum-target);
				if(gap<minGap)
				{
					result = sum;
					minGap = gap;
				}
				if(sum<target)
				{
					j++;
				}
				else
				{
					k--;
				}
				
			}
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		int[] nums =  {-1, 2, 1, -4};
		int target= 2;
		int  result = find(nums, target);
		System.out.println(result);
	}
}
