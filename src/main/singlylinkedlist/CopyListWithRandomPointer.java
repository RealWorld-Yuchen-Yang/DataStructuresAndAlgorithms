package main.singlylinkedlist;

/**
 * Problem: 
 * 	A linked list is given such that each node contains an additional random pointer
 * 	which could point to any node in the list or null
 * 	Return a deep copy of the lists
 * 
 * Analysis: 
 * 	We could reduce the space complexity into constant. 
 * 	The idea is to associate the original node with its copy node in a singly linked lsit
 * 	In this way, we do not need extra space to keep track of the new nodes
 * 
 * 	step1: Iterate the original list and duplicate each node. 
 * 		   The duplicate of each node follows its original immediately
 * 	step2: Iterate the new list and assign the random pointer for each duplicated node
 * 		Note: the demand for step2 is because in the construction of step1, 	
 * 			  we do not have a global view of the list yet
 * 	step3: Restore the original list and extract the duplicated nodes
 * 
 * @author yuchenyang
 *
 */
public class CopyListWithRandomPointer
{
	public static RandomListNode copyRandomList(RandomListNode head)
	{
		RandomListNode iter = head;
		RandomListNode next;
		
		/*
		 * step1: make copy of each node, 
		 *  and link them together side-by-side in a singly linked list
		 *  Note: the copied nodes are actually inserted behind the original list's nodes respectively
		 *  	  general case structure is : ......cur->curCopy->next->nextCopy......
		 */
		while(iter != null)
		{
			next = iter.next;
			
			RandomListNode copy = new RandomListNode(iter.label);
			iter.next = copy;
			copy.next = next;
			
			iter = next;
		}
		
		//step2: assign random pointers for the copy nodes
		iter = head;
		while(iter != null)
		{
			if(iter.random != null)
			{
				/*
				 * here 
				 * 	1) iter is pointing to the original list's node
				 * 	2) iter.next is pointing to the corresponding copied node
				 */
				iter.next.random = iter.random.next;
			}
			iter = iter.next.next;//move the iterPointer to the original list's next node 
		}
		
		//step3: restore the original list, and extract the copy list
		iter = head;
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode copy;
		RandomListNode copyIter = dummy;
		
		while(iter != null)
		{
			next = iter.next.next;//store the original list's next node position
			
			//extract the copy
			copy = iter.next;//current copy position(one step behind it original mirror)
			copyIter.next = copy;//update the copiedListNode's next pointer 
			copyIter = copy;//move copiedList's iterator one further
			
			//restore the original list
			iter.next = next;
			iter = next;
		}
		
		return dummy.next;
	}
	
	private static class RandomListNode
	{
		int label;
		RandomListNode next;
		RandomListNode random;
		
		public RandomListNode(int label)
		{
			this.label = label;
		}
	}
}
