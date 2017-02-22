package main.binarytree;

import java.util.Stack;

/**
 * Requirement: Implement an iterator over a binary search tree(BST). 
 * 				Your iterator will be initialized with the root node of the BST
 * 				Calling next() will return the next smallest number in the BST
 * 				Note: next() and hasNext() should run in average o(1) and use o(h) memory, 
 * 					  where h is the height of the tree
 * 
 * Analysis: This is an example of implementing non-recursive inorder traversal
 * 			 Use a stack to store nodes on the way from root to left-most child
 * 			 In each iteration, pop() one element at a time. As a return value of next()
 * 			 At the same time, we need to test if the current node has a right child
 * 			 If it does, we move to the right child, and iteratively push nodes 
 * 			 on the way from this right child to its left-most child 
 * @author yuchenyang
 *
 */
public class BSTIterator {
	private Stack<TreeNode> stack;
	/**
	 * build the Iterator by iteratively pushing nodes on the left-most branch
	 * @param root
	 */
	public BSTIterator(TreeNode root)
	{
		
		stack = new Stack();
		TreeNode p = root;
		while(p != null)
		{
			stack.push(p);
			p = p.left;
		}
	}
	
	public boolean hasNext()
	{
		return !stack.isEmpty();
	}
	
	public int next()
	{
		final TreeNode node = stack.pop();//this is always the most left-bottom node
		if(node.right != null)
		{
			TreeNode p =node.right;
			while(p != null)
			{
				stack.push(p);
				p = p.left;
			}
		}
		
		return node.val;
	}
	
}
