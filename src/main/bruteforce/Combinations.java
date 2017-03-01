package main.bruteforce;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * 	Given two integers n and k, return all possible combinations of k numbers out of 1...n
 * 
 * Still incremental construction will be used
 * 
 * @author yuchenyang
 *
 */
public class Combinations
{
	public static List<List<Integer>> combination(int n, int k)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> stepResult = new ArrayList<>();
		if(n<=0 || k<=0|| k>n)
		{
			return result;
		}
		combination(1, k, n, result, stepResult);
		return result;
	}
	
	private static void combination(int start, int k, int n, List<List<Integer>> result, List<Integer> stepResult)
	{
		//terminate condition: when only select 1 element
		if(k == 0)
		{
			result.add(new ArrayList(stepResult));
			return;
		}
		
		for(int i=start; i<=n; i++)
		{
			stepResult.add(i);
			combination(i+1, k-1, n, result, stepResult);
			stepResult.remove(stepResult.size()-1);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
