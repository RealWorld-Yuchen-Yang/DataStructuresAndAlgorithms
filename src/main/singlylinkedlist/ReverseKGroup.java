package main.singlylinkedlist;

/**
 * 
 * @author yuchenyang
 *
 */
public class ReverseKGroup
{
	/**
	 * Recursive solution
	 */
	public static ListNode reverseKGroup(ListNode head, int k)
	{
		ListNode cur = head;
		int count = 0;
		while(cur != null && count != k)//find the (k+1)th node
		{
			cur = cur.next;
			count++;
		}
		if(count == k)
		{
			//if (k+1)th node is found(before reaching the end)
			cur = reverseKGroup(cur, k);//reverse list with (k+1)th node as head
			
			//reveres the k elements at the beginning of the list
			while(count>0)
			{
				count--;
				//insert cur in front of the input list's head, iteratively 
				ListNode tmp = head.next;//next node in the direct part
				head.next = cur;//preappending "direct" head to the reversed list
				cur = head;//move head of reversed part to a new node
				head = tmp;//move head to the next node in the front k elements
			}
			head = cur;
		}
		return head;
	}
}
