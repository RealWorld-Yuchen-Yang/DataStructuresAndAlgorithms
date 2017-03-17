package main.singlylinkedlist;

/**
 * Problem: 
 * 	Given a singly linked list L: l0->l1->...->l(n-1)->ln, 
 * 	reorder it to: 
 * 	l0->ln->l1->l(n-1)...
 * 
 * 	you must do this in-place without altering the nodes' values
 * 	
 * Analysis: 
 * 	step1: we can cut the list into two
 * 	step2: reverse the second part
 * 	step3:  merge the two lists
 * @author yuchenyang
 *
 */
public class ReorderList
{
	public static ListNode reorderList(ListNode head)
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;
		
		while(fast != null && fast.next != null)
		{
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		prev.next = null;//cut at middle
		
		/*
		 * reverse(slow): reverse the second half of the original list
		 * since currently 
		 * 	slow is pointing to the head of the second list
		 * 	fast is pointing to the original list's end
		 */
		slow = reverse(slow);
		
		//merget the two lists
		ListNode cur = head;//
		while(cur.next != null)
		{
			ListNode tmp = cur.next;
			cur.next = slow;
			slow = slow.next;
			cur.next.next = tmp;
			cur = tmp;
		}
		cur.next = slow;
		
		return head;
	}
	
	private static ListNode reverse(ListNode head)
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		
		//use three consecutive pointers: prev, cur, next to reverse a list
		ListNode prev = head;
		for(ListNode cur = head, next = cur.next;
				cur != null;
				prev = cur, cur = cur.next, next = next != null? next.next: null)
		{
			cur.next = prev;//reverse the list by iteratively point the current node to its previous node
		}
		
		head.next = null;
		return prev;
	}
}
