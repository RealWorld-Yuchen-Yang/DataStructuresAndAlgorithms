package main.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
	public static List stackImp(TreeNode root)
	{
		List<Integer> result = new LinkedList();
		Stack<TreeNode> s = new Stack();
		TreeNode p = root;//pointer to the tree's root
		
		while(!s.isEmpty() || p != null)
		{
			if(p != null)
			{
				s.push(p);//currently store the "middle node"
				p = p.left;
			}
			else
			{
				p = s.pop();//after the push and pop, p.left's order is made to be before p itself
				result.add(p.val);
				p = p.right;
			}
		}
		
		return result;
	}
}
