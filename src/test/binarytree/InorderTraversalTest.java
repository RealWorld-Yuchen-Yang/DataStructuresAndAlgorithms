package test.binarytree;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.binarytree.InorderTraversal;
import main.binarytree.PreorderTraversal;
import main.binarytree.TreeNode;

public class InorderTraversalTest {
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
	
	@Before
	public void expectedList()
	{
		expected = new LinkedList();
		expected.add(1);
		expected.add(3);
		expected.add(2);
		expected.add(4);
	}
	
	@Test
	public void testStackImp()
	{
		List<Integer> result = InorderTraversal.stackImp(root);	
		Assert.assertArrayEquals(expected.toArray(), result.toArray());

	}
}
