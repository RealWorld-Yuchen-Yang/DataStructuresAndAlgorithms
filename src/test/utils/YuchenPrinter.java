package test.utils;

import main.sorting.ListNode;

public class YuchenPrinter
{
	public static void printArray(int[] array, String name)
	{
		if(array != null && array.length != 0)
		{
			System.out.print("Array-"+name+": {");
			for(int i=0; i<array.length; i++)
			{
				System.out.print(array[i]);
				if(i == array.length -1)
				{
					System.out.print("}\n");
				}
				else
				{
					System.out.print(",");
				}
			}
		}
	}
	
	/**
	 * This is a helper method
	 * given a head pointer of a list
	 * print the list
	 * @param head
	 */
	public static void printListFrom(ListNode head)
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
		System.out.println();
	}
}
