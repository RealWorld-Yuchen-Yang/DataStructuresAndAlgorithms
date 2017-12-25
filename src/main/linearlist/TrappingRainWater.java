package main.linearlist;

import java.util.Arrays;

/**
 * Problem: 
 * 	Given n non-negative integers representing an elevation map 
 * 	where the width of each bar is 1, 
 * 	compute how much water it is able to trap after raining
 * 	e.g. Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * @author yuchenyang
 * 
 * Analysis: 
 * 	Approach1: for each pillar, find the highest pillar to its right/left respectively. 
 * 			   The current pillar's water volumn is min(maxLeft, maxRight)-height
 * 				
 * 			   Step1: create helper array, maxLeftArray,
 * 					   parse original array left-->right, 
 * 					   find maxLeft of each pillar
 * 			   Step2: create helper array, maxRightArray,
 * 				       parse original array right-->left,
 * 				  	   find maxRight of each pillar 	
 * 			   Step3: parse the array again, and add up each pillar's volume
 */
public class TrappingRainWater
{
	public static int trap(int[] nums)
	{
		assert nums!=null;
		final int n=nums.length;
		int[] maxLeftHelper = new int[n];
		int[] maxRightHelper = new int[n];
		
		for(int i=1; i<n; i++)
		{
			maxLeftHelper[i] = Math.max(maxLeftHelper[i-1], nums[i-1]) ;
		}
		for(int i=n-2; i >=0; i--)
		{
			maxRightHelper[i] = Math.max(maxRightHelper[i+1], nums[i+1]);
		}
		
		int totalVolume = 0;
		for(int i=0; i<n; i++)
		{
			int boundaryHeight = Math.min(maxLeftHelper[i], maxRightHelper[i]);
			int volume = boundaryHeight - nums[i];
			if(volume > 0)
			{
				totalVolume+=volume;
			}
		}
		return totalVolume;
	}


	public static void main(String[] args){}
}
