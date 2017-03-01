package main.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	public static void main(String[] args) {
		//incrementalConstructionSolutionTest
		int[] inputSet = { 2, 3, 1 };

		List<List<Integer>> result = Subsets.incrementalConstructionSolution(inputSet);
		System.out.println("Final Result:");
		for (List<Integer> eachSet : result) {
			System.out.println("	"+eachSet.toString());
		}
	}
	
	public static List<List<Integer>> iterativeSolution(int[] nums)
	{
		//sort the input array so as to get ascending results
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList());//empty subset
		for(int elem: nums)
		{
			final int n = result.size();//size of the on the fly result
			for(int i=0; i<n; i++)
			{
				//copy itself
				result.add(new ArrayList(result.get(i)));
			}
			/*
			 * after the copy, size of the result has doubled
			 * we need to brute forcly add a new element in the copied over sets
			 */
			for(int i=n; i<result.size();i++)
			{
				
				result.get(i).add(elem);
			}
		}
		return result;	
	}
	
	
	public static List<List<Integer>> incrementalConstructionSolution(int[] nums)
	{
		assert nums != null;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> stepSolution = new ArrayList();
		
		Arrays.sort(nums);
		incrementalConstruction(nums, result, stepSolution, 0);
		return result;
	}
	
	/**
	 * This is a depth first search solution
	 */
	private static void incrementalConstruction(int[] nums, List<List<Integer>> result, List<Integer> stepSolution, int index)
	{
		//terminate condition
		if(index == nums.length){
			/*
			 * index == nums.length means no matter how many elements we add into the stepPath,
			 * if we have passed through each elements in the given set, we are done. 
			 * and "pass through" here means, either add-in or not 
			 */
			System.out.println("Acutal step solution added-in: "+stepSolution+"\n");
			result.add(new ArrayList<Integer>(stepSolution));
			return;
		}
		
		
		/*
		 * do not add nums[index], move on to next step directly,
		 * this is like starting one thread, which is used to deal the no-selecting nums[index] situation 
		 */
		incrementalConstruction(nums, result, stepSolution, index+1);
		
		//Just printing the current whole Result
		System.out.println(index+" Step Result:");
		for (List<Integer> eachSet : result) {
			System.out.println("	"+eachSet.toString());
		}
		
		/*
		 * add num[index]
		 * this is like starting another thread, which is used to deal the selecting nums[index] situation
		 */
		System.out.println("Before adding nums[index], step solution: "+stepSolution+"\n");
		stepSolution.add(nums[index]);
		System.out.println("After adding nums[index], step solution: "+stepSolution+"\n");
		
		incrementalConstruction(nums, result, stepSolution, index+1);
		System.out.println("Before removing nums[index], step solution: "+stepSolution+"\n");
		/*
		 * The removal of added element is very important, 
		 * because we are going over all each element every iteration, 
		 * we need to make sure the previous stepSolution has no impact on the next round
		 * that is index(0->nums.length-1)  
		 */
		stepSolution.remove(stepSolution.size()-1);
		System.out.println("After removing nums[index], step solution: "+stepSolution+"\n");
	}
	
	
	
	
	
}
