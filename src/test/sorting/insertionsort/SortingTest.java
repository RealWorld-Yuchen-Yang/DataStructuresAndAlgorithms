package test.sorting;

import org.junit.Before;
import org.junit.Test;

import main.sorting.ListNode;
import main.sorting.insertionsort.InsertionSortList;
import test.utils.YuchenPrinter;

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
		YuchenPrinter.printListFrom(inputListHead);
		ListNode head = InsertionSortList.insertionSortList(inputListHead);
		YuchenPrinter.printListFrom(head);
	}
	

	
}
