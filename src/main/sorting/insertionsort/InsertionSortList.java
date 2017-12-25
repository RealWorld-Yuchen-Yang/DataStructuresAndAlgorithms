package main.sorting.insertionsort;

import main.sorting.ListNode;

/**
 * the sorted list will be in ascending order
 */
public class InsertionSortList {
	   public static ListNode insertionSortList(ListNode head) {
	        ListNode dummy = new ListNode(Integer.MIN_VALUE);
	        //dummy.next = head;

	        for (ListNode cur = head; cur != null;) {
	            ListNode pos = findInsertPos(dummy, cur.val);
	            ListNode tmp = cur.next;//before modification, firstly store the orignal cur.next

	            /*
	             * insert node "cur" after node "pos",
	             * remember, when doing insertion,
	             * always handle the "next" pointer first, then the node itself
	             */
	            cur.next = pos.next;
	            pos.next = cur;

	            /*
	             * move the cur pointer one step further
	             * note that, we are not trying to link the anything to cur
	             * which means we have broken the array into two parts,
	             * and the break point it before the "cur" node
	             */
	            cur = tmp;
	        }
	        return dummy.next;
	    }

	   /*
	    * insert position is the previous position that firstly containing value > the current value,
			* it should be switched with the current node
	    */
	    private static ListNode findInsertPos(ListNode head, int x) {
	        ListNode pre = null;
	        for (ListNode cur = head; cur != null && cur.val <= x;
	             pre = cur, cur = cur.next)
	            ;
	        return pre;
	    }
}
