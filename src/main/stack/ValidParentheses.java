package main.stack;

import java.util.Stack;

/**
 * Problem: 
 * 	Given a string containing just the characters '(', ')', '[',  ']', '{', '}'
 * 	determine if the input string is valid
 * 
 * @author yuchenyang
 *
 */
public class ValidParentheses
{
	public boolean isValid(String s)
	{
		final String left = "([{";
		final String right = ")]}";
		
		Stack<Character> stack = new Stack();//used to store the left parentheses
		
		for(int i=0; i<s.length();i++)
		{
			final char c = s.charAt(i);
			if(left.indexOf(c) != -1)
			{
				stack.push(c);
			}
			else
			{
				if(!stack.isEmpty() && stack.peek() == left.charAt(right.indexOf(c)))
				{
					/*
					 * this is the main logic of this algorithm
					 * check if the current examining char has a previously pushed left counter part
					 * if there exists, pop the stack top
					 */
					stack.pop();
				}
				else
				{
					return false;
				}
			}
			
		}	
		return stack.isEmpty();
	}
}
