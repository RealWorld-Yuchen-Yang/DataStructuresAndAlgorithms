package main.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates,
 *  return all possible subsets
 *  
 * @author yuchenyang
 *
 */
public class SubsetsII {
	public static void main(String[] args)
	{
		int[] inputSetWithDup = {1,2,2};
		List<List<Integer>> result = incrementalConstructionSolution(inputSetWithDup);
		for(List<Integer> stepSolution: result)
		{
			System.out.println(stepSolution.toString());
		}
	}
	
	public static List<List<Integer>> incrementalConstructionSolution(int[] nums)
	{
		assert nums != null;
		Arrays.sort(nums);
		
		List<List<Integer>> result = new ArrayList();
		List<Integer> stepSolution = new ArrayList();//empty set
		
		incrementalConstruction(nums, 0, stepSolution, result);
		return result;
	}
	
	private static void incrementalConstruction(int[] nums, int index, List<Integer> stepSolution, List<List<Integer>> result)
	{
		result.add(new ArrayList<Integer>(stepSolution));
		
		for(int i = index; i<nums.length; i++)
		{
			if(i != index && nums[i] == nums[i-1])
			{
				/* Condition1: i == index
				 * we need to add it in the final result set
				 * for it represents the non-adding nums[i] condition
				 * 
				 * Condition2: nums[i] == nums[i-1])
				 * if the current value equals its predecessor, 
				 * we ignore it to avoid duplicated set
				 * 
				 * And here duplicate means set's duplicate, 
				 * not element's duplicate in one set
				 */
				continue;
			}
			
			stepSolution.add(nums[i]);
			incrementalConstruction(nums, i+1, stepSolution, result);
			stepSolution.remove(stepSolution.size()-1);
		}
	}
}
