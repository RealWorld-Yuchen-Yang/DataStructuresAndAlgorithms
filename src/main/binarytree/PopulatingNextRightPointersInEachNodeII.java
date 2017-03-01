package main.binarytree;

/**
 * Note: you may only use constant extra space
 * Say given
 *      1
 *    /  \
 *   2    3
 *  / \    \
 * 4   5    7
 *
 * I am supposed to generate
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \    \
 * 4-> 5 -> 7 -> NULL
 *
 *
 */
public class PopulatingNextRightPointersInEachNodeII
{
    public static void recursiveConnect(TreeLinkedNode root)
    {
        if(root == null)
            return;
        TreeLinkedNode dummy = new TreeLinkedNode(-1);
        /*
           curr is the current node,
           prev node is the previous node of the linkedList in the next level of the currnet node(on the same level)
           prev starts from the currentNode's leftChild
         */
        for(TreeLinkedNode curr =  root, prev = dummy; curr != null; curr = curr.next)//move the curr from left to right(in the same level)
        {
            if(curr.left != null)
            {
                prev.next = (TreeLinkedNode) curr.left;
                prev = prev.next;
            }
            if(curr.right != null)
            {
                prev.next = (TreeLinkedNode) curr.right;
                prev = prev.next;
            }
        }
        recursiveConnect(dummy.next);
    }

    public static void iterativeSolution(TreeNode root)
    {
        //ToDo
    }


}
