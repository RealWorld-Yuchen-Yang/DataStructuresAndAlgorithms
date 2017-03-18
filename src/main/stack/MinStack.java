package main.stack;

import java.util.Stack;

/**
 * Problem: 	
 * 	Design a stack that supports push, pop, top, and retrieving the minimum element in constant time. 
 * 	push(x) --Push element x onto stack
 * 	pop(x) --Removes the element on top of the stack
 * 	top() --Get the top element
 * 	getMin() --Retrieve the minimum element in the stack
 * 
 * Analysis: 
 * 	Initialize two stacks, one as the main storage, the other as supportive
 * 	Whenever the supportive stack pushes,
 * 	it compares the current element with its top element, and pushes the smaller one
 * 
 * @author yuchenyang
 *
 */
public class MinStack
{	
	private Stack<Integer> s = new Stack();//main storage
	private Stack<Integer> minStack = new Stack();//supportive stack
	
	//most important method of the MinStack
	public void push(int x)
	{
		s.push(x);
		int minValue = minStack.isEmpty()?x:Math.min(minStack.peek(), x);
		/*
		 * What minStack pushed into itself is that moment's min element in s.
		 * It records a state
		 */
		minStack.push(minValue);
	}
	
	public void pop()
	{
		s.pop();
		minStack.pop();
	}
	
	public int top()
	{
		return s.peek();
	}
	
	public int getMin()
	{
		return minStack.peek();
	}
}
