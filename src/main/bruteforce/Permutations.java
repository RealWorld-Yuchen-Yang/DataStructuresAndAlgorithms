package main.bruteforce;

import java.util.ArrayList;
import java.util.List;

/**
 * Find no duplicate element arrays permutations
 * 
 * @author yuchenyang
 *
 */
public class Permutations
{
	public static void main(String[] args)
	{
		int[] inputArray = {1,2,3};
		 List<List<Integer>> result = permutation(inputArray);
		 for(List<Integer> stepResult: result)
		 {
			 System.out.println(stepResult.toString());
		 }
	}
	
	public static List<List<Integer>> permutation(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
		{
			return result;
		}
		List<Integer> stepResult = new ArrayList<Integer>();
		permutation(nums, stepResult, result);
		return result;
	}

	private static void permutation(int[] nums, List<Integer> stepResult, List<List<Integer>> result)
	{
		// Terminating condition: the stepResult is containing all elements of
		// the given array
		if (stepResult.size() == nums.length)
		{
			result.add(new ArrayList(stepResult));// deep copy of the
													// stepResult;
			return;
		}

		for (int i = 0; i < nums.length; i++)
		{
			if (stepResult.contains(nums[i]))
			{
				continue;
			}
			stepResult.add(nums[i]);
			permutation(nums, stepResult, result);
			stepResult.remove(stepResult.size()-1);
		}

	}
}
