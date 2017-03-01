package main.binarytree;

import java.util.Stack;

/**
 * Compare to see if the two tree are the same
 */
public class SameTree {
	public static boolean recursiveSolution(TreeNode p, TreeNode q)
	{
		if(p == null && q == null)
			return true;//terminating point
		if(p == null || q == null)
			return false;//trim: by removing impossible cases
		return //tail recursion, which merges the three cases--node.left, node, node.right
				p.val == q.val
				&& recursiveSolution(p.left, q.left)
				&& recursiveSolution(p.right, q.right);			
	}
	
	//this is preorder traversal's implementation
	public static boolean iterativeSolution(TreeNode p, TreeNode q)
	{
		Stack<TreeNode> s = new Stack();
		s.push(p);
		s.push(q);
		
		while(!s.isEmpty())
		{
			p = s.pop();
			q = s.pop();
			
			if(p == null && q == null)
				continue;//terminate this round
			if(p == null || q == null)
				return false;//trim
			if(p.val != q.val)
				return false;//trim
			
			s.push(p.left);
			s.push(q.left);

			s.push(p.right);
			s.push(q.right);
		}
		
		return true;
	}
}
