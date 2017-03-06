package main.linearlist;

import java.util.HashMap;

/**
 * Problem:
 * Given an array of integers(Unsorted),
 * find two numbers such that they add up to a specific target number
 * The function twoSum should return indices of the two numbers, 
 * and index1< index2. Note that indices are not 0-based
 * 
 * Analysis: 
 * 	approach1: brute force, time complexity O(n^2), exceeds time limit
 * 	approach2: use HashMap,<key, value>: <elementValue, elementIndex>, time complexity O(n)
 * 	approach3: firstly sort the list(time complexity O(nlogn)), approach the target from both sides(time complexity O(n))
 * 			   however, since the desired output are the indices, this approach is not applicable 
 * 
 * @author yuchenyang
 *
 */
public class TwoSum
{
	public static int[] twoSum(int[] nums, int target)
	{
		assert nums!=null;
		final HashMap<Integer, Integer> map = new HashMap<>();
		int[] result = new int[2];
		for(int i=0; i<nums.length; i++)
		{
			map.put(nums[i], i);
		}
		for(int i=0; i<nums.length;i++)
		{
			final Integer index2 = map.get(target - nums[i]);
			if(index2 != null && index2 >i)
			{
				result = new int[]{i+1, index2+1};
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		int[] nums={2,7,11,15};
		int target = 9;
		int[] result = twoSum(nums, target);
		System.out.println("Indices: "+result[0]+","+result[1]);
	}
	
}
