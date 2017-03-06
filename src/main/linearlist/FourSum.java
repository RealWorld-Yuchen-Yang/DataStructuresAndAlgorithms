package main.linearlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Problem
 * Given an array nums of n integers,
 * are there elements a,b,c,d in nums that a+b+c+d = targe?
 * 
 * Find all unique quadruplets in the array which gives the sum of target
 * 
 * Analysis: 
 * 	Approach1: 
 * 		step1: sort the array
 * 		step2: using loops and start from both sides to approach the final target
 * 			   Note: all the outer loops approach from the start
 * 					 only the inner-most loop approach from both sides 
 * 		time complexity: O(n^3)
 * 	Approach2:
 * 		step1: use a HashMap to cache sum of two number
 * 		time complexity: O(n^3)
 * @author yuchenyang
 *
 */
public class FourSum
{
	public static List<List<Integer>> approach1(int[] nums, int target)
	{
		List<List<Integer>> result = new ArrayList();
		if(nums.length<4)
		{
			return result;
		}
		Arrays.sort(nums);
		
		for(int i=0; i<nums.length-3; i++)
		{
			if(i>0 && nums[i]==nums[i-1])
			{
				continue;
			}
			for(int j = i+1; j<nums.length-2; j++)
			{
				if(j>i+1 && nums[j]==nums[j-1])
				{
					continue;
				}
				int k = j+1;
				int l= nums.length-1;
				while(k<l)
				{
					final int sum = nums[i]+nums[j]+nums[k]+nums[l];
					if(sum<target)
					{
						k++;
						while(nums[k]==nums[k-1]&&k<l)
						{
							k++;
						}
					}
					if(sum>target)
					{
						l--;
						while(nums[l]==nums[l+1]&&k<l)
						{
							l--;
						}
					}
					else
					{
						result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
						while(nums[k]==nums[k-1]&&k<l)
						{
							k++;
						}
						while(nums[l]==nums[l+1]&&k<l)
						{
							l--;
						}
					}
				}
			}
		}
		
		return result;
	}
	public static List<List<Integer>> approach2(int[] nums, int target)
	{
		List<List<Integer>> result = new ArrayList();
		if(nums.length<4)
		{
			return result;
		}
		Arrays.sort(nums);
		
		final HashMap<Integer, ArrayList<int[]>> cache = new HashMap();
		for(int i=0; i<nums.length;i++)
		{
			for(int j=i+1; j<nums.length;j++)
			{
				ArrayList<int[]> value = cache.get(nums[i]+nums[j]);
				if(value == null)
				{
					//if the nums[i]+nums[j] value combination has not appeared
					value = new ArrayList();
					cache.put(nums[i]+nums[j], value);
				}
				value.add(new int[]{i,j});
			}
		}
		
		final HashSet<String> used = new HashSet();//avoid duplicates
		for(int i=0; i<nums.length; i++)
		{
			if(i>0 && nums[i]==nums[i-1])
			{
				continue;
			}
			for(int j=i+1;j<nums.length-2;j++)
			{
				if(j>i+1 && nums[j] == nums[j-1])
				{
					continue;
				}
				final ArrayList<int[]> list = cache.get(target - nums[i]-nums[j]);
				if(list == null)
				{
					continue;
				}
				for(int[] pair: list)
				{
					if(j>=pair[0])
					{
						continue;//overlap
					}
					
					final Integer[] solution = new Integer[]{nums[i], nums[j], nums[pair[0]], nums[pair[1]]};
					Arrays.sort(solution);
					
					final String key = Arrays.toString(solution);
					
					if(!used.contains(key))
					{
						result.add(Arrays.asList(solution));
						used.add(key);
					}
				}
			}
			
		}
		return result;
	}
}
