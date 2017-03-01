package test.binarytree;

import main.binarytree.InorderTraversal;
import main.binarytree.InvertBinaryTree;
import main.binarytree.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yucheny on 2/21/17.
 */
public class InvertBinaryTreeTest
{
    TreeNode root;
    List expected;

    /*
     *    1
     *      \
     *        2
     *      /   \
     *     3      4
     */
    @Before
    public void buildTree()
    {
        root = new TreeNode(1);
        TreeNode level1Right = new TreeNode(2);
        TreeNode level2Left = new TreeNode(3);
        TreeNode level2Right = new TreeNode(4);

        root.right = level1Right;
        level1Right.left = level2Left;
        level1Right.right = level2Right;
    }

    /*
     *        1
     *       /
     *      2
     *    /  \
     *   4    3
     *   Expected inorder array representation is: [4,2,3,1]
     */
    @Before
    public void expectedList()
    {
        expected = new LinkedList();
        expected.add(4);
        expected.add(2);
        expected.add(3);
        expected.add(1);
    }

    @Test
    public void testStackImp()
    {
        InvertBinaryTree.levelOrderTraversalSolution(root);
        List<Integer> result = InorderTraversal.stackImp(root);
        Assert.assertArrayEquals(expected.toArray(), result.toArray());

    }

}
