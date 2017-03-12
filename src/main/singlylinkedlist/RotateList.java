package main.singlylinkedlist;

/**
 * Problem:
 * Given a list, rotate the list to the right by k places, 
 * where k is non-negative
 * 
 * Example: 
 * 	Given 1->2->3->4->5 and k=2, return 4->5->1->2->3
 * 
 * Analysis:
 * 	step1: parse the list, so as to find the length "len"
 * 		   since k can be greater then len, k %= len
 * 	step2: link the tail to the head, so as to form a ring, by pointing the tail.next to head
 * 	step3: move the pointer(currently pointing to the head) (len-k) steps and break the ring
 * 
 * @author yuchenyang
 *
 */
public class RotateList
{
	public static ListNode rotateRight(ListNode head, int k)
	{
		if(head == null || k == 0)
		{
			return head;
		}
		
		//calculate len
		int len = 1;
		ListNode p = head;
		while(p.next != null)
		{
			len++;
			p = p.next;
		}
		
		k = len - k%len;
		
		//form the ring, p was the end of the list
		p.next = head;
		for(int step = 0; step<k; step++)
		{
			p = p.next;
		}
		
		head = p.next;//assign the (len-k%len)th node to the new head
		p.next = null;//cut the ring at the link before the new head
		return head;
	}
}	
