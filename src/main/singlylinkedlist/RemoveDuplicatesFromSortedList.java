package main.singlylinkedlist;

/**
 * Problem:
 * Given a sorted linked list, 
 * delete all duplicate such that each element appear only once. 
 * @author yuchenyang
 * 
 * Analysis: 
 * 	iterate through the list, 
 * 	if currentNode's value equals previousNode's value, 
 * 	skip the current node
 * 	else
 * 	keep iterating
 *
 */

public class RemoveDuplicatesFromSortedList
{
	public static ListNode removeDuplicates(ListNode head)
	{
		if(head == null)
		{
			return null;
		}
		
		for(ListNode prev = head, cur = head.next; cur != null;//only if the furtherest pointer reaches null will we stop iterating. In this case is "cur"
				cur = prev.next)
		{
			if(prev.val == cur.val)
			{
				prev.next = cur.next;
			}
			else
			{
				prev = cur;
			}
		}
		return head;
	}
}			
