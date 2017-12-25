package main.sorting.mergesort;

import main.sorting.ListNode;

/**
 * Requirement: 
 * 		Merge k sorted linked lists and return one sorted list. 
 * 
 * Analysis: 
 * 		Approach1: 
 * 			Can iteratively use MergeTwoSortedList.merge()
 * 			Time Complexity: O(n1+n2+..)
 * 			Space Complexity: O(1)
 * 		Approach2: 
 * 			Can parallelly merge the lists in lists array
 * 			Time Complexity: O(max(n1, n2, ...)
 * 			Space Complexity: O(lists.length)
 * @author yuchenyang
 *
 */
public class MergeKSortedLists
{
	public static ListNode mergeKLists(ListNode[] lists)
	{
		if(lists.length == 0)
		{
			return null;
		}
		else if(lists.length == 1)
		{
			return lists[0];
		}
		else
		{
			ListNode p = lists[0];
			for(int i = 1; i<lists.length; i++)
			{
				p = MergeTwoSortedLists.mergeTwoLists(p, lists[i]);
			}
			return p;
		}
	}
	
}
