package main.singlylinkedlist;

/**
 * Problem: 
 * 	Given a linked list, determine if it has a cycle in it. 
 * 	Follow up: can you solve it without using extra space?
 * 
 * Analysis: 
 * 	Approach1(naive): 
 * 		Use a helper HashTable<Integer, Boolean> visited,
 * 		to store if a node has been visited.	
 * 		If one node was visited, then it means cycle exists
 * 		However, this approach requires O(n) space complexity
 * 	Approach2: 
 * 		step1: declear two pointers, slow and fast
 * 		step2: let fast move two steps at a time, while slow move one step at a time
 * 			   If they meet, which is the node they are pointing to are the same, 
 * 			   which can be determined by if their "address" are the same,
 * 			   then it means the original list has cycle.
 * @author yuchenyang
 *
 */
public class LinkedListCycle
{
	public static boolean  hasCycle(ListNode head)
	{
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
			{
				return true;
			}
		}
		return false;
	}
}
