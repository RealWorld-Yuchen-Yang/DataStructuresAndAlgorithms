package main.singlylinkedlist;

/**
 * Problem:
 * 	Given a singly linked list, determine if it is a palindrome
 * 
 * Analysis:
 * 
 * Approach1: time complexity O(n), space complexity O(n) 
 * 	step1: use fast-slow pointer approach to find the middle point of the list
 * 		   also use a helper stack to store each value that the slow pointer has been pointed to
 *  step2: currently, the slow pointer is pointing to the original list's second half's head
 *  		iterate through the second half by using the slow pointer. 
 *  		compare each element with the stack's top value, 
 *  		return true if all elements are equal
 *  		otherwise return false
 * 
 * Approach2: time complexity O(n), space complexity O(1), which is implemented below
 * 	step1: same as Approach1, use fast-slow pointer approach to find the middle point of the list
 * 	step2: reverse the second half
 * 	step3: compare to see if the first half of the original list is the same as the reversed second half
 * @author yuchenyang
 *
 */
public class PalindromeLinkedList
{
	public static boolean isPalindrome(ListNode head)
	{
		if(head == null)
		{
			return true;
		}
		
		//find middle point
		final ListNode middle = findMiddle(head);
		//reverse the second half
		middle.next = reverse(middle.next);
		
		ListNode p1 = head;
		ListNode p2 = middle.next;
		while(p1!=null &&p2!=null
			&&p1.val == p2.val)
		{
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2 == null;
	}
	
	private static ListNode findMiddle(ListNode head)
	{
		if(head == null)
		{
			return head;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;//currently, slow.next is pointing to the head of the middle point
	}
	
	private static ListNode reverse(ListNode head)
	{
		ListNode prev = null;
		while(head != null)
		{
			ListNode tmp = head.next;
			head.next = prev;
			prev = head;
			head = tmp;
		}
		return prev;
	}
	
	
}
