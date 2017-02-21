package main.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
	
	/*
	 * Idea: 
	 * recursively push the currentRoot, currentRoot.right, currentRoot.left into a stack
	 * And then pop them inorder 
	 */
	public static List stackImp(TreeNode root)
	{
		List<Integer> result = new LinkedList<Integer>();
		Stack<TreeNode> s = new Stack();
		if(root != null)
			s.push(root);
		
		while(!s.isEmpty())
		{
			final TreeNode p = s.pop();
			result.add(p.val);
			if(p.right!=null)
				s.push(p.right);
			if(p.left!= null)
				s.push(p.left);
		}
		
		return result;
	} 
}
