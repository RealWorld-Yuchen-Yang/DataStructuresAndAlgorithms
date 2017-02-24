package test.sorting;

import org.junit.Before;
import org.junit.Test;

import main.sorting.ListNode;

public class SortingTest {
	
	ListNode inputListHead;
	
	/**
	 * build a link as 5->7->2->8->1->9 
	 */
	@Before
	public void buildLinkedList()
	{
		ListNode node9 = new ListNode(9);
		ListNode node1 = new ListNode(1, node9);
		ListNode node8 = new ListNode(8,node1);
		ListNode node2 = new ListNode(2, node8);
		ListNode node7 = new ListNode(7, node2);
		inputListHead = new ListNode(5, node7);
	}
	
	@Test
	public void insertionSortTest()
	{
		ListNode p = inputListHead;
		printListFrom(inputListHead);
	}
	
	/**
	 * This is a helper method
	 * given a head pointer of a list
	 * print the list
	 * @param head
	 */
	private void printListFrom(ListNode head)
	{
		ListNode p = head;
		while(p != null)
		{
			System.out.print(p.val);
			if(p.next != null)
			{
				System.out.print("->");
			}
			p=p.next;
		}
	}
	
}
