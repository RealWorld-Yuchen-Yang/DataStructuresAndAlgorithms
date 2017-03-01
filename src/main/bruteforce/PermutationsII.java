package main.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find the permutation of a given array with possibility of duplicates
 * 
 * Analysis: 
 * Difference between the none-duplicate one and the has-duplicate one is 
 * 	1. We are using "boolean[] visited" to mark if a position of the given array has been visited
 * 	   It is because we can not simply use contain(nums[i]) to determine if a element is visited. 
 *  2. After sorting the input array, we skip consecutive duplicates
 *     so as to eliminate duplicated permutations to be calculated.
 * 
 * @author yuchenyang
 *
 */
public class PermutationsII
{
	// incremental construction solution
	public static List<List<Integer>> permutation(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> stepResult = new ArrayList<Integer>();
		if (nums == null || nums.length == 0)
		{
			return result;
		}
		
		Arrays.sort(nums);
		
		boolean[] visited = new boolean[nums.length];
		permutation(nums, result, stepResult, visited);
		return result;
	}

	/**
	 *  
	 * @param nums
	 * @param result
	 * @param stepResult
	 * @param visited,
	 *            an array whose length is the same as the given array. It is
	 *            used to mark each stepResult's building source--the given
	 *            array's position If it has been visited or not. Needed if
	 *            there are duplicates
	 */
	private static void permutation(int[] nums, List<List<Integer>> result, List<Integer> stepResult, boolean[] visited)
	{
		if (stepResult.size() == nums.length)
		{
			result.add(new ArrayList(stepResult));
			return;
		}
		
		for(int i=0; i<nums.length; i++)
		{
			if(visited[i])
			{
				continue;	
			}
			
			visited[i] = true;
			stepResult.add(nums[i]);
			permutation(nums, result, stepResult, visited);
			//restore stepResult
			visited[i] = false;
			stepResult.remove(nums[i]);
			
			//skip consecutive duplicates
			while(i<nums.length-1 && nums[i] == nums[i+1])
			{
				i++;
			}
		}
		
		
		
		
		
		
		
		
		
		
	}
}
