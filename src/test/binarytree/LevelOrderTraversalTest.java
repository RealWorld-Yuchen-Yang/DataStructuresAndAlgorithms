package test.binarytree;

import main.binarytree.InorderTraversal;
import main.binarytree.LevelOrderTraversal;
import main.binarytree.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yucheny on 2/21/17.
 */
public class LevelOrderTraversalTest
{

    TreeNode root3;
    List expected;

    /*
     *     3
     *   /  \
     *  9   20
     *     /  \
     *    15   7
     */
    @Before
    public void buildTree()
    {
        root3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        root3.left = node9;
        root3.right = node20;
        node20.left = node15;
        node20.right = node7;
    }

    @Before
    public void expectedList()
    {
        expected = new LinkedList();

        LinkedList levelList = new LinkedList();
        levelList.add(3);
        expected.add(levelList);

        levelList = new LinkedList();
        levelList.add(9);
        levelList.add(20);
        expected.add(levelList);

        levelList = new LinkedList();
        levelList.add(15);
        levelList.add(7);
        expected.add(levelList);
    }

    @Test
    public void testStackImp()
    {
//        List<List<Integer>> result = LevelOrderTraversal.recursiveImp(root3);
        List<List<Integer>> reversedResult = LevelOrderTraversal.inReverseOrder(root3);
//        result.toArray();
        reversedResult.toArray();
    }
}
