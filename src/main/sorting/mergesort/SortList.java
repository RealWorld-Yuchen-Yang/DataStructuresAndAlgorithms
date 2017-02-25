package main.sorting.mergesort;

import main.sorting.ListNode;

/**
 * Requirement: 
 * 	Sort a linked list in O(nlogn)time using constant space complexity
 * 
 * Analysis: 
 * 	recursively merge sort the front and end part of the list
 * @author yuchenyang
 *
 */
public class SortList
{
	public static ListNode sort(ListNode head)
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		
		//find the middle point of the original list
		final ListNode middle = findMiddle(head);
		
		//split the original list into two
		final ListNode head2 = middle.next;
		middle.next = null; //this represent the front part's end
		
		//recursively sort the front and second part of the original list, respectively
		final ListNode l1 = sort(head);
		final ListNode l2 = sort(head2);
		
		//finally merge the two parts together
		return merge(l1, l2);
	}
	
	
	private static ListNode merge(ListNode l1, ListNode l2)
	{
		ListNode dummy = new ListNode(-1);
		for(ListNode p = dummy; l1 != null || l2 != null; p = p.next)
		{
			/*
			 * when the node is null, we assign the max value to it
			 * so that in the following comparing step
			 * it represents a invalid value
			 */
			int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
			int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
			
			if(val1 <= val2)
			{
				p.next = l1;
				l1 = l1.next;
			}
			else
			{
				p.next = l2;
				l2 = l2.next;
			}
		}
		
		return dummy.next;
	}
	
	//use "fast-slow pointer" solution to find the middle point of a linkedList
	private static ListNode findMiddle(ListNode head)
	{
		if(head == null)
		{
			return null;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		/*
		 * here fast.next represents the real end of the list
		 * fast != null is just testing the first case in which the input list is null
		 */
		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	
	
	
	
	
	
	
}
