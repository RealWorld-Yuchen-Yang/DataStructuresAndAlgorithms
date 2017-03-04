package main.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string only digits, restore it by returning all possible valid IP
 * address combinations
 * 
 * For example, Given, "25525511135" return ["255.255.11.135", "255.255.111.35"]
 * 
 * Analysis: Requirement is to cut the given string into 4 ip pieces, no
 * sequence manipulation Since you can only determine the result after parsing
 * the whole string depth-first-search should be applied
 * 
 * Time complexity: O(n^4)
 * 
 * @author yuchenyang
 *
 */
public class RestoreIPAddress
{
	private static final char SEPARATOR = '.';

	public List<String> restoreIpAddress(String s)
	{
		List<String> result = new ArrayList();
		List<String> intermediateResult = new ArrayList();
		dfs(s, intermediateResult, result, 0);
		return result;
	}

	/**
	 * 
	 * @param s[in],
	 *            input digitString
	 * @param intermedaiteResult[out],
	 *            ip segments of one result ip address
	 * @param result[out],
	 *            stores all possible ip results
	 * @param start[in],
	 *            currently inspecting index Note that this is the strategy of
	 *            how java tries to return multiple results, Initialize output
	 *            containers outside a method, and in the method take "output
	 *            containers as input"
	 */
	private static void dfs(String s, List<String> intermedaiteResult, List<String> result, int start)
	{
		// terminate condition, found one available solution
		if (intermedaiteResult.size() == 4 && start == s.length())
		{
			StringBuilder sb = new StringBuilder();
			sb.append(intermedaiteResult.get(0)).append(SEPARATOR).append(intermedaiteResult.get(1)).append(SEPARATOR)
					.append(intermedaiteResult.get(2)).append(SEPARATOR).append(intermedaiteResult.get(3));
			return;
		}

		if (s.length() - start > ((4 - intermedaiteResult.size()) * 3))
		{
			//cut, s violates maximum size, in the above expression, 3 stands for "3digits" maximum digits in one ip address segment 
			return;
		}
		if(s.length() - start < (4 - intermedaiteResult.size()))
		{
			//cut, s violates minimum size, in the above expression, the implicit "1" stands for "3digits" minimum "1digit" in one ip address segment 
			return;
		}
		
		int num = 0;
		for(int i=start; i<start+3 && i<s.length();i++)
		{
			num = num*10 + (s.charAt(i) - '0');
			if(num<0 || num>255)
			{
				continue;
			}
			intermedaiteResult.add(s.substring(start, i+1));
			dfs(s, intermedaiteResult, result, i+1);
			intermedaiteResult.remove(intermedaiteResult.size()-1);
			if(num == 0)
			{
				break;//does not allow leading 0, but single 0
			}
		}
	}
}
