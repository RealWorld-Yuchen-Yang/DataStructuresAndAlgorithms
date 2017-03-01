package main.sorting.mergesort;

import main.sorting.ListNode;

/**
 * Requirement:
 *   Merge two sorted linked lists and return it as a new list 
 *   The new list should be made by splicing together the nodes of the first two lists
 * 
 * Analysis: 
 *   When dealing with "LinkedList", 
 *   it is usually convenient to initialize a dummy node as a new head of the list
 *   And the dummy node should be initialized with
 *   
 *     value: MIN_AVAILIABLE_VALUE/MAX_AVAILIABLE_VALUE, depends on requirement
 *     nextPointer: pointing to the given/result list
 *   With this dummy node, I can manipulate the original list head without loosing control
 * @author yuchenyang
 *
 */
public class MergeTwoSortedLists
{
	/**
	 * Merge sort in increasing order
	 * @param l1
	 * @param l2
	 * @return dummy.next, which is the head of the sorted increasing-ordered list
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
	{
		if(l1 == null )
		{
			return l2;
		}
		if(l2 == null)
		{
			return l1;
		}
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
		
		//dealing with situation: l1 and l2 both have elements
		for(; l1 != null && l2 != null; p = p.next)
		{
			if(l1.val < l2.val)
			{
				p.next = l1;//assign l1's current node to the result list
				/*
				 * move the l1's pointer to the next node,
				 * even though this will destory the original l1
				 */
				l1 = l1.next;
			}
			else
			{
				p.next = l2;
				l2 = l2.next;
			}
		}
		
		/*
		 * dealing with situation: 
		 * 	l1 and l2, at least one of them is empty at this moment
		 * 	try to link the non-empty list in the end 
		 */
		p.next = l1 != null? l1 : l2;
	
		return dummy.next;
	}
}
