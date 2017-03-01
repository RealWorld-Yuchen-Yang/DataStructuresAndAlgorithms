package main.binarytree;

/**
 * Givey a binary tree, flatten it to a linked list in place
 * Notice that in place is very important, which means you can not use anohter linked list to represent the flattened tree
 * but build from what was originally there
 *
 *  say, given:
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 *
 *  result should be:
 *  1->2->3->4->5->6->null
 */
public class FlattenBinaryTreeToLinkedList
{
    public static void recursiveSolution(TreeNode root)
    {
        if(root == null)
            return;//terminate
        recursiveSolution(root.left);
        recursiveSolution(root.right);

        if(root.left == null)
            return;

        /*
            merge the three parts:
            root-->rootLeftNodeList -> rootRightNodeList
         */

        //point p to the root's leftChild's right-most child
        TreeNode p = root.left;
        while(p.right != null)
            p = p.right;

        p.right = root.right;//from the above example, we are doing link 5->6 behind 4
        root.right = root.left;//from the above example, we are doing link 2->3 after 1
        root.left = null;
    }

}
