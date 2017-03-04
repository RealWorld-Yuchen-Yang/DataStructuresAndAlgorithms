package main.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers
 * 
 * Ensure that numbers within the set are sorted in ascending order
 * 
 * Example1:
 * Input: k=3, n=7
 * Output: [[1,2,4]]
 * 
 * Example2: 
 * Input: k=3, n=9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * notice that [3,3,3] is not a valid result, because element duplicate exists
 * 
 * Analysis: 
 * this is a brute force depth first search, 
 * the first digit has 9 choices(since there are 10 digits, and digit 0 has no contribution to sum), 
 * the second digit has 9-1=8 choices
 * ...
 * till (10-k) digits left
 * 
 * Time Complexity: O(9*8*...*(10-k))
 * 
 * @author yuchenyang
 *
 */
public class CombinationSumIII
{
	/**
	 * 
	 * @param k, #of elements used to sum up n
	 * @param n, desired sum n
	 * @return
	 */
	public static List<List<Integer>> combinationSumIII(int k, int n)
	{
		final List<List<Integer>> result = new ArrayList();
		final List<Integer> intermediateResult = new ArrayList<>();
		dfs(k, n, intermediateResult, result);
		return result;
	}
	
	private static void dfs(int step, int gap, List<Integer> intermediateResult, List<List<Integer>> result)
	{
		if(step == 0)
		{
			//use up #of elements
			if(gap == 0)
			{
				//if at this point, gap happens to be 0, then we find a valid combination
				result.add(new ArrayList(intermediateResult));
			}
		}
		
		if(gap<1)
		{
			return;//cut path, no validity down this path
		}
		
		//start represents the "this round value's starting point"
		final int start = intermediateResult.isEmpty() ? 1: intermediateResult.get(intermediateResult.size()-1)+1;
		for(int i=start; i<10;i++)
		{
			intermediateResult.add(i);
			dfs(step-1, gap-i, intermediateResult, result);
			intermediateResult.remove(intermediateResult.size()-1);
		}
	}
	
	public static void main(String[] args)
	{
		int inputK = 3;
		int inputN = 9;
		List<List<Integer>> result = combinationSumIII(inputK, inputN);
		for(List<Integer> intermediateResult: result)
		{
			System.out.println(intermediateResult);
		}
	}
	
}
