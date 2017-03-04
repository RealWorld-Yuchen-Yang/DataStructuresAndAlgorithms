package main.depthfirstsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 
 * Similar to CombiationSum, 
 * only difference is each number in C may only be used once in one result 
 * @author yuchenyang
 *
 */
public class CombinationSumII
{
	public static List<List<Integer>> combinationSumII(int[] nums, int target)
	{
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList();
		List<Integer> intermediateResult = new ArrayList();
		dfs(nums, result, intermediateResult, target, 0);
		return result;
	}
	
	private static void dfs(int[] nums, List<List<Integer>> result, List<Integer> intermediateResult, int gap, int start)
	{
		if(gap == 0)
		{
			result.add(new ArrayList(intermediateResult));
			return;
		}
		
		int previous = -1;//introducing previous cache is the only difference from CombinationSum
		for(int i=start; i<nums.length; i++)
		{
			if(previous == nums[i])
			{
				//skip duplicate elements
				continue;
			}
			
			if(gap<nums[i])
			{
				//cut path, no possibility
				return;
			}
			
			previous = nums[i];//update previous valaue
			
			intermediateResult.add(nums[i]);
			dfs(nums, result, intermediateResult, gap - nums[i], i+1);
			intermediateResult.remove(intermediateResult.size()-1);
			
			
			
			
			
			
			
			
		}
	}
}
