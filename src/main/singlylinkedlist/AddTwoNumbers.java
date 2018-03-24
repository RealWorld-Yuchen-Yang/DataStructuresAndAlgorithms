package main.singlylinkedlist;

/**
 * Problem:
 * 	Given two linkedLists representing two non-negative numbers. 
 * 	The digits are stored in reverse order and each of their nodes contains a single digit.
 * 	Add the two numbers and return it as a linkedList
 * Example:
 * 	Input: (2->4->3) + (5->6->4), which are 342 + 465
 * 	Output: (7->0->8), which is 807
 * 
 * Analysis: add each node from head to tail, 
 * 			output node one at a time, containing value of sum%10,
 * 			the carry will be moved to the next iteration
 * @author yuchenyang
 *
 */
public class AddTwoNumbers
{	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		ListNode dummy = new ListNode(-1);
		int carry = 0;
		ListNode pre = dummy;//pre represent the pointer to the result list
		for(ListNode p1 = l1, p2 = l2; 
				p1 != null || p2!=null;
				p1 = p1 == null ? null: p1.next,
				p2 = p2 == null ? null: p2.next,
				pre = pre.next//pre will be created in the previous iteration
			)
		{
			//main calculation logic
			final int val1 = p1 == null ? 0: p1.val;
			final int val2 = p2 == null ? 0: p2.val;
			final int radixSum = val1+val2+carry;
			final int radix = radixSum%10;
			carry=radixSum/10;
			pre.next = new ListNode(radix);
		}
		
		//deal with last potential "carry" radix
		if(carry>0)
		{
			pre.next = new ListNode(carry);
		}
		return dummy.next;
	}
}
