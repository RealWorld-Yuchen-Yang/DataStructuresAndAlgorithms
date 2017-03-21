package main.stack;

import java.util.Stack;

/**
 * Problem: 
 *  Implement the following operations of a queue using stacks
 *  push(x) -- Push element x to the back of queue
 *  pop(x) -- Removes the element from in front of queue
 *  peek(x) -- Get teh front element
 *  empty() -- Return whether the queue is empty
 *  
 * Notes: 
 * 	You must use only standard operations of a stack -- 
 * 	which means only push to top, peek/pop from top, size and isEmpty operations are valid
 * 
 * Analysis: 
 * 	Use two stacks s and tmp, 
 * 		s is used to store elements
 * 		tmp is used as a helper
 * 	push(x), firstly pop all elements in s, and push them into tmp, 
 * 			then pop these elements back onto s
 * 	pop(), pop s's elements directly
 * @author yuchenyang
 *
 */
public class ImplementQueueUsingStacks
{
	private final Stack s = new Stack<>();
	private final Stack tmp = new Stack<>();
	
	//Time Complexity: O(n)
	public void push(int x)
	{
		//deal with previous elements
		while(!s.isEmpty())
		{
			final int element = (int) s.pop();
			tmp.push(element);
		}
		//deal with the input x
		tmp.push(x);
		
		while(!tmp.isEmpty())
		{
			final int element = (int) tmp.pop();
			s.push(element);
		}
		
	}
	
	public void pop()
	{
		s.pop();
	}
	
	public int peek()
	{
		return (int) s.peek();
		
	}
	
	public boolean empty()
	{
		return s.isEmpty();
	}
	
}
