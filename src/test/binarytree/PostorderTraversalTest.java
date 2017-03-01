package test.binarytree;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.binarytree.InorderTraversal;
import main.binarytree.PostorderTraversal;
import main.binarytree.TreeNode;

public class PostorderTraversalTest {
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
		expected.add(3);
		expected.add(4);
		expected.add(2);
		expected.add(1);
	}
	
	@Test
	public void testStackImp()
	{
		List<Integer> result = PostorderTraversal.stackImp(root);
		System.out.println("Expected: "+expected);
		System.out.println("Result: "+result);
		System.out.println("Recursive Result: ");
		postorderRecur(root);
		Assert.assertArrayEquals(expected.toArray(), result.toArray());
	}
	
	private void postorderRecur(TreeNode root)
	{
		if(root != null)
		{
			postorderRecur(root.left);
			postorderRecur(root.right);
			System.out.println(root.val);
		}
		
	}

}
