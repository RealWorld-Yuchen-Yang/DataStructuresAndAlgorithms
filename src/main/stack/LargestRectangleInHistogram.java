package main.stack;

import java.util.Stack;

/**
 * Problem: 
 * 	Given n non-negative integers representing the histogram's bar height
 * 	where the width of each bar is 1.
 *  Find the area of largest rectangle in the histogram. 
 *  
 * @author yuchenyang
 *
 */
public class LargestRectangleInHistogram
{
	public int largestRectangleArea(int[] heights)
	{
		Stack<Integer> s = new Stack<>();
		int result = 0;
		for(int i=0; i<heights.length; )
		{
			final int value = i<heights.length?heights[i]:0;
			if(s.isEmpty() || value > heights[s.peek()])
			{
				//push the currentMax's index onto the stack
				s.push(i++);
			}
			else
			{
				/*
				 * in the previous values, 
				 * there exists a value that is greater than the current one
				 * which is now stored in the local variable "tmp"
				 */
				int tmp = s.pop();
				result = Math.max(result, heights[tmp]*(s.isEmpty() ? i: i-s.peek()-1));
			}
		}
		return result;
	}
}
