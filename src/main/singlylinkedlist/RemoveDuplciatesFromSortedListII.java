package main.singlylinkedlist;

/**
 * Given a sorted linked list delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list. 
 * 
 * @author yuchenyang
 *
 */
public class RemoveDuplciatesFromSortedListII
{
	public static ListNode deleteDuplication(ListNode head)
	{
		if(head == null)
		{
			return head;
		}
		
		ListNode dummy = new ListNode(Integer.MAX_VALUE);
		dummy.next = head;
		ListNode prev= dummy;
		ListNode cur = head;
		
		while(cur!= null)
		{
			boolean duplicated = false;
			while(cur.next != null && cur.val == cur.next.val)
			{
				//reduce the duplicates to only one occurrence
				duplicated = true;
				cur = cur.next;
			}
			if(duplicated)
			{
				cur = cur.next;//remove the previously duplicate's last occurrence
				continue;
			}
			
			//move the prev and cur pointer to their next position respectively
			prev.next = cur;
			prev = prev.next;
			cur = cur.next;
		}
		
		prev.next = cur;
		return dummy.next;
		
	}
	
}
