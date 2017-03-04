package main.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 * Problem: Given n pairs of parentheses, write a function to generate all
 * combinations of well-formed parentheses
 * 
 * Analysis: parentheses sequence is a recursive structure. whenever
 * #leftParentheses < n, we can generate additional leftParentheses whenever
 * #leftParentheses > #rightParenthese, we can generate additional
 * rightParentheses
 * 
 * @author yuchenyang
 *
 */
public class GenerateParentheses
{
	public static List<String> generateParenthesis(int n)
	{
		List<String> result = new ArrayList();
		StringBuilder path = new StringBuilder();
		if (n > 0)
		{
			generateParentheses(n, path, result, 0, 0);
		}
		return result;
	}

	/**
	 * 
	 * @param n
	 * @param path
	 * @param l,
	 *            # of '(' has already been generated
	 * @param r,
	 *            # of ')' has already been generated
	 */
    private static void generateParentheses(int n, StringBuilder path, List<String> result, int l, int r)
    {
    	if(l == n)
    	{
    		StringBuilder sb = new StringBuilder(path);
    		for(int i=0; i<n-r;i++)
    		{
    			sb.append(')');
    		}
    		result.add(sb.toString());
    		return;
    	}
    	
    	path.append('(');
    	generateParentheses(n, path, result, l+1, r);
    	path.deleteCharAt(path.length() - 1);
    	
    	if(l>r)
    	{
    		path.append(')');
    		generateParentheses(n, path, result, l, r+1);
    		path.deleteCharAt(path.length() - 1);
    	}
    }
  


	public static void main(String[] args)
	{
		int inputN = 5;
		List<String> result = generateParenthesis(inputN);

		for (String s : result)
		{
			System.out.println(s);
		}
	}
}
