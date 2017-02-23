package test.binarytree;

import main.binarytree.FlattenBinaryTreeToLinkedList;
import main.binarytree.TreeNode;
import org.junit.Test;

/**
 * Created by yucheny on 2/22/17.
 */
public class FlattenBinaryTreeToLinkedListTest
{
    @Test
    public void recursiveSolutionTest()
    {
//        int[] exptected = {1,2,3,4,5,6};

        /*
         *  say, given:
         *          1
         *         / \
         *        2   5
         *       / \   \
         *      3   4   6
         */
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.right = node6;

        FlattenBinaryTreeToLinkedList.recursiveSolution(node1);
        TreeNode p = node1;
        while(p!= null)
        {
            System.out.print(p.val);
            if(p.right != null)
            {
                System.out.print("->");
            }
            else
            {
                System.out.println();
            }
            p = p.right;
        }
    }
}
