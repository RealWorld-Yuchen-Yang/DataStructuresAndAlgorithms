package main.singlylinkedlist;

/**
 * Problem: Reverse a linkedList from position m to n. Do it in-place and in
 * one-pass; For example: Given 1->2->3->4->5, m=2, and n=4 return 1->4->3->2->5
 * (which means index of the node starts from 1)
 * 
 * Note: Given m, n satisfy 1<=m<=n<=length
 * 
 * @author yuchenyang
 *
 */
public class ReverseLinkedListII
{
	/**
	 * 
	 * @param head
	 * @param m,
	 *            reverse start index
	 * @param n,
	 *            reverse end index
	 * @return
	 */
	public static ListNode reverseBetween(ListNode head, int m, int n)
	{
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		//Move the prev pointer to index m
		ListNode prev = dummy;
		for(int i=0; i<m-1;i++)
		{
			prev = prev.next;
		}
		ListNode head2 = prev;
		
		prev = head2.next;
		ListNode cur = prev.next;
		for(int i=m; i<n; i++)
		{
			//move the prev.next and cur.next
			prev.next = cur.next;
			cur.next = head2.next;
			
			//insert the cur node at head of the reverse list
			head2.next = cur;
			cur = prev.next;
		}
	
		return dummy.next;
	}

}
