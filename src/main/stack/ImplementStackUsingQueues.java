package main.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: 
 * 	Implement the following operations of a stack using queue
 * 		push(x) -- Push element x onto stack
 * 		pop() -- Removes the element on top of the stack
 * 		top() -- Get the top element
 * 		empty() -- Return whether the stack is empty
 * 
 * Note: 
 * 	You must use only standard operations of a queue, 
 * 	which means only push to back, peek/pop from front, size, and isEmpty
 * 	
 *  You may assume that all operations are valid(for example, no pop or top operations will be called on an empty stack) 
 * 
 * Analysis: 
 * 	Use two queues, q and tmp
 * 		q stores values, 
 * 		tmp is used as a helper
 * 	push(x):
 * 		step1: enqueue x onto tmp, 
 * 		step2: dequeue all element in q, then enqueue them onto tmp
 * 		step3: switch q and tmp
 * 	pop(x)
 * 		step1: based on the way of pushing, we just need to dequeue head element in q
 * 
 * @author yuchenyang
 *
 */
public class ImplementStackUsingQueues
{
	public void push(int x)
	{
		tmp.offer(x);//enqueue x, offer is defined on Queue Interface
		while(!q.isEmpty())
		{
			final int e = (int) q.poll();//dequeue, poll() is defined on the Queue Interface
			tmp.offer(e);//immediately enqueue e into tmp
		}
		
		//swap q and tmp
		Queue temp = tmp;
		tmp = q;
		q = tmp;
	}
	
	public void pop()
	{
		q.poll();
	}
	
	public int top()
	{
		return (int) q.peek();
	}
	
	public boolean empty()
	{
		return q.isEmpty();
	}
	
	private Queue q = new LinkedList();
	private Queue tmp = new LinkedList();
}
