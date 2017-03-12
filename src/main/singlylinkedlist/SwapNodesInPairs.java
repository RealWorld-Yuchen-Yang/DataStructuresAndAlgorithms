package main.singlylinkedlist;

/**
 * Problem: 
 * 	Given a linked list, swap every two adjacent nodes and return its head
 * 	For example, Given 1->2->3->4, you should return the list as 2->1->4->3
 * 	Your algorithm should use only constant space. 
 * 	You may not modify the values in the list, 
 * 	only nodes itself can be changed
 * 
 * Analysis: 
 * 	we initialize three pointers prev, cur, next,
 * 	pointing to three consecutive nodes
 * 	
 * General case: 
 * 		step1: point the pre.next to next
 * 		step2: insert the current between next and next.next
 * 	
 * Stop condition: when next pointer reaches null
 * 	
 * @author yuchenyang
 *
 */
public class SwapNodesInPairs
{
	public static ListNode swapPairs(ListNode head)
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		for(
				/*
				 *initialize three consecutive pointers: prev, cur, next, starting from dummy
				 */
				ListNode prev = dummy, cur = prev.next, next = cur.next;
			    next != null;
				/*
				 * update in this way is because: after the previous iteration's pointer swapping
				 * prev, cur, next's position is as follows: 
				 * prev->next->cur->next.next
				 * we would like to
				 *  1) mode prev to the cur position, and
				 *  2)at the same time maintain these three pointer's relative position
				 */
				prev = cur, cur = cur.next, next = cur!=null?cur.next:null)
		{
			//link prev to the next, by pointing prev's next to next
			prev.next = next;
			//insert cur between next and next.next
			cur.next = next.next;
			next.next = cur;
		}
		
		return dummy.next;
	}
}
