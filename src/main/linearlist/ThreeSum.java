package main.linearlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 
 * 	Given an array nums of n integers,
 *  are there elements, a,b,c in nums such that
 *  a+b+c = 0? 
 *  Find all unique triplets in the array which gives the sum of 0?
 * 	Note: 
 * 		1. Elements in a triplet (a,b,c) must be in non-descending order
 * 		2. The solution set must not contain duplicate triplets
 * 
 *  Analysis: 
 *   we can sort the array first then approach from both sides
 *   time complexity O(n^2), 
 *   this approach can also be applied to k-sum
 *   which is 
 *   	Step1: sort
 *   	Step2: use k-2 loops, in the most inner loop, approach from both sides, 
 *   	Time complexity O(max{nlogn, n^(k-1))	  
 *   
 * @author yuchenyang
 *
 */

public class ThreeSum
{
	public static List<List<Integer>> threeSum(int[] nums)
	{
		List<List<Integer>> result = new ArrayList();
		if(nums.length < 3)
		{
			return result;
		}
		Arrays.sort(nums);
		final int target = 0;
		
		/*
		 * index i<j<k
		 * the out most loop is iterate through i
		 * the inner loops start from both sides, the graph will be as follows
		 * [(front)-->(i)-->(j)-->...<--(k)<--(end)
		 * Note, in each inner loop, i is fixed, only j and k will be moving asynchronously
		 */
		for(int i=0; i< nums.length; i++)
		{
			if(i>0 && nums[i] == nums[i-1])
			{
				/*
				 * here we are skipping same nums[i] compared with previous iteration
				 * so as to eliminate duplicate [nums[i],nums[j],nums[k]] combinations
				 * however, we do not prevent nums[i], nums[j], nums[k] to be of the same value
				 */
				continue;
			}
			int j = i+1;//initialize j from the next item of i
			int k = nums.length-1;
			while(j<k)
			{
				if(nums[i]+nums[j]+nums[k]<target)
				{
					j++;
					while(nums[j]==nums[j-1]&&j<k)
					{
						//skip nums[j] duplicate while valid
						j++;
					}
				}
				else if(nums[i]+nums[j]+nums[k]>target)
				{
					k--;
					while(nums[k]==nums[k+1] && j<k)
					{
						//skip nums[k] duplicate while valid
						k--;
					}
				}
				else
				{
					//one result has been found
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					++j;
					--k;
					while(nums[j] == nums[j-1] && j<k)
					{
						j++;
					}
					while(nums[k] == nums[k+1] && j<k)
					{
						k--;
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> results = threeSum(nums);
		for(List<Integer> result: results)
		{
			System.out.println(result);
		}
	}
}
