package main.singlylinkedlist;

public class ReverseLinkedList
{
	public static void main(String[] arts)
	{
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
		ListNode node6=new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = null;
		
		printList(node1);
		ListNode solution1 = recursiveSolution(node1);
		printList(solution1);
	}
	
	private static void printList(ListNode head)
	{
		StringBuffer sb = new StringBuffer();
		
		while(head != null)
		{
			sb.append(head.val);
			sb.append("->");
			head = head.next;
		}
		System.out.println(sb.toString());
	}
	
	
	/**
	 * Time complexity O(n)
	 * @param head
	 * @return
	 */
	public static ListNode iterativeSolution(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode tail = null;
        ListNode p = head;
        ListNode q = p.next;

        while (q != null) {
            ListNode old = q.next;
            p.next = tail;
            q.next = p;

            tail = p;
            p = q;
            q = old;
        }
        return p;
    }
	
	/**
	 * Main idea: 
	 * 	step1 store the currentHead's next as tail
	 * 	step2: make the currentHead's next as null
	 * 	step3: get the new head
	 * 	step4: link the old head to the tail
	 * 
	 * 	step5: break out the recursion and return new head
	 * @param head
	 * @return
	 */
	public static ListNode recursiveSolution(ListNode head)
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		
		//conclude: always assign first, then modify
		ListNode tail = head.next;
		head.next = null;
		ListNode newHead = recursiveSolution(tail);
		tail.next = head;
		
		return newHead;
	}
}
