package main.singlylinkedlist;

/**
 * Problem: Given a singly linked list, group all odd nodes together followed by
 * even nodes. Here odd, even is regarding to the index of nodes, instead of
 * node values You should try to do it in place. The program should run in O(1)
 * space complexity and O(n) time complexity Note: 1. The relative order inside
 * both the even and odd groups should remain as it was in the input 2. The
 * first node is considered odd, the second node even and so on.
 * 
 * Analysis: Create two empty linkedLists, Add the odd nodes into the first one
 * Add the even nodes into the second one
 * 
 * @author yuchenyang
 *
 */
public class OddEvenLinkedList
{
	public static ListNode oddEvenList(ListNode head)
	{
		final ListNode oddDummy = new ListNode(0);
		final ListNode evenDummy = new ListNode(0);
		ListNode odd = oddDummy;
		ListNode even = evenDummy;

		int index = 1;
		while (head != null)
		{
			if(index % 2 == 1)
			{
				odd.next = head;//head represents the current head, which will be updated later
				odd = odd.next;
			}
			else
			{
				even.next = head;//head represents the current head, which will be updated later
				even = even.next;
			}
			
			ListNode tmp = head.next;//store the currentNode's next node information
			head.next = null;//manipulate the current head node
			head = tmp;//move the head pointer to the next position
			index++;//update the index number
		}
		
		odd.next = evenDummy.next;
		return oddDummy.next;
	}
}
