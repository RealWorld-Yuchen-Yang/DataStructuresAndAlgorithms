package main.stack;

import java.util.Stack;

/**
 * Problem 
 * 	Given a string containing just the characters '(' and ')', 
 * 	find the length of the longest valid(well-formed) parentheses substring
 * 
 * @author yuchenyang
 *
 */
public class LongestValidParentheses
{
	/**
	 * Time complexity O(n), space complexity O(n)
	 * @param s
	 * @return
	 */
	public int stackSolution(String s)
	{
		int maxLength = 0;
		//position of the last ')'
		int lastRightIndex = -1;
		
		//keep track of the positions of non-matching '('s
		Stack<Integer> lefts = new Stack();
		
		for(int i=0; i<s.length();i++)
		{
			if(s.charAt(i) == '(')
			{
				//push every '(' index
				lefts.push(i);
			}
			else
			{
				/*
				 * for the  premise has already said 
				 * that the string only contains characters '(' and ')'
				 * the currently examining character has to be ')'
				 */
				if(lefts.empty())
				{
					/*
					 * Only update the lastRightIndex when
					 * currently examining ')' has no matching left
					 * which means a subsequence of '(' & ')' has ended
					 */
					lastRightIndex = i;
				}
				else
				{
					/*
					 * previously pushed '(' has matching ')'
					 * which is the currently examining character
					 */
					lefts.pop();
					if(lefts.empty())
					{
						maxLength = Math.max(maxLength, i-lastRightIndex);
					}
					else
					{
						maxLength = Math.max(maxLength, i-lefts.peek());
					}
					
				}	
			}
		}
		return maxLength;
	}
}
