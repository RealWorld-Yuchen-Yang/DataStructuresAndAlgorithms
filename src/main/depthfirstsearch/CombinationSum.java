package main.depthfirstsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.shape.Path;

/**
 * Given a set of candidate numbers(c) and a target number(T) find all unique
 * combinations in c where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from c unlimited number of times.
 * 
 * Note: All numbers(including target) will be positive integers Elements in a
 * combination(a1, a2, ..., ak) must be in non-descending order The solution
 * must not contain duplicate combinations
 * 
 * @author yuchenyang
 *
 */
public class CombinationSum
{
	public static List<List<Integer>> combinationSun(int[] nums, int target)
	{
		Arrays.sort(nums);//sort nums in ascending order
		List<List<Integer>> result = new ArrayList();
		List<Integer> intermediateResult = new ArrayList();
		dfs(nums, intermediateResult, result, target, 0);
		return result;
	}
	
	private static void dfs(int[] nums, List<Integer> intermediateResult, List<List<Integer>> result, int gap, int start)
	{
		if(gap == 0)
		{
			result.add(new ArrayList(intermediateResult));
			return;
		}
		
		for(int i=start; i<nums.length; i++)
		{
			if(gap<nums[i])
			{
				return;//cut, no possible solution down this path
			}
			
			intermediateResult.add(nums[i]);
			dfs(nums, intermediateResult, result, gap-nums[i],i);
			intermediateResult.remove(intermediateResult.size()-1);
		}
	}

}
