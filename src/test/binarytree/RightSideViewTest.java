package test.binarytree;

import main.binarytree.InorderTraversal;
import main.binarytree.RightSideView;
import main.binarytree.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yucheny on 2/21/17.
 */
public class RightSideViewTest
{
    TreeNode root;
    List expected;

    /*
     *      1
     *     / \
     *    2   3
     *     \   \
     *      5   4
     */
    @Before
    public void buildTree()
    {
        root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node3;
        node2.right = node5;
        node3.right = node4;
    }

    @Before
    public void expectedList()
    {
        expected = new LinkedList();
        expected.add(1);
        expected.add(3);
        expected.add(4);
    }

    @Test
    public void testStackImp()
    {
        List<Integer> result = RightSideView.solve(root);
        Assert.assertArrayEquals(expected.toArray(), result.toArray());

    }
}
