package main.singlylinkedlist;

/**
 * Problem: 
 * 	Given a linkedList and a value x, partition it such that all nodes
 * 	less than x come before nodes greater than or  equal to x
 * 	You should preserve the original relative order of the nodes in each of the two partitions
 * 	
 * @author yuchenyang
 *
 */
public class PartitionList
{
	public static ListNode partition(ListNode head, int x)
	{
		ListNode leftDummy = new ListNode(-1);
		ListNode rightDummy = new ListNode(-1);
		
		ListNode leftCur = leftDummy;
		ListNode rightCur = rightDummy;
		
		for(ListNode cur = head; cur != null; cur = cur.next)
		{
			if(cur.val <x)
			{
				leftCur.next = cur;//point the leftList's next node to the cur node in the original list
				leftCur = cur;//move the leftList's cur pointer to the previously just assigned next position
			}
			else
			{
				rightCur.next = cur;
				rightCur = cur;
			}
		}

		//link the leftList and rightList together
		leftCur.next = rightDummy.next;
		rightCur.next = null;

		return leftDummy.next;
	}
}
