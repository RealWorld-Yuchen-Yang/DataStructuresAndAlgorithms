package main.singlylinkedlist;

/**
 * Problem: 
 * 	Given a linkedList, remove the n-th node from the end of list and return its head
 * 
 * Analysis: 
 * 	initiate two pointers p, q from the dummy head(node before the real head)
 * 	let q move n steps by itself
 * 	then move q and p together, until q reaches the end of the list
 * 	currently, p's next is pointing to the n-th element, we can just just remove it 	
 * @author yuchenyang
 *
 */
public class RemoveNthNodeFromEndOfList
{
	public static ListNode removeNthFromEnd(ListNode head, int n)
	{
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode p = dummy;
		ListNode q = dummy;
		
		for(int i=0; i<n; i++)
		{
			q = q.next;
		}
		
		while(q.next != null)
		{
			p = p.next;
			q = q.next;
		}
		
		//currently p->next is pointing to the n-th element of the given list
		p.next = p.next.next;//skip(remove) n-th element
		
		return dummy.next;
	}
}
