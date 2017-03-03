package main.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s, such that every substring of the partition is a palindrome
 * Return all possible palindrome partitioning of s
 * @author yuchenyang
 *
 */
public class PalindromePartitioning
{
	public static List<List<String>> partition(String s)
	{
		List<List<String>> result = new ArrayList();
		List<String> stepResult = new ArrayList();
		dfs(s, stepResult, result, 0);
		return result;
	}
	
	private static  void dfs(String s, List<String> stepResult, List<List<String>> result, int start)
	{
		if(start == s.length())
		{
			result.add(new ArrayList(stepResult));
			return;
		}
		for(int i=start; i<s.length(); i++)
		{
			if(isPalindrome(s, start, i))
			{
				//add only palindrome in the result
				stepResult.add(s.substring(start, i+1));//separate at i
				dfs(s,stepResult,result, i+1);
				stepResult.remove(stepResult.size()-1);
			}
		}
	}
	
	//this is a good way of test palindrome!!!!
	private static boolean isPalindrome(String s, int start, int end)
	{
		while(start < end && s.charAt(start) == s.charAt(end))
		{
			++start;
			--end;
		}
		return start >= end;
	}
}
