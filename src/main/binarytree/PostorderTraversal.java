package main.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * Order: left, right, root
 */
public class PostorderTraversal {
	public static List stackImp(TreeNode root)
	{
		List<Integer> result = new LinkedList();
		Stack<TreeNode> s = new Stack();//stack is used to change the visit order
		
		TreeNode p = root;//p is pointing to the currently visiting node
		TreeNode q = null;//q is pointign to the previously visited node(current's right child)
		
		do
		{
			while(p != null)
			{
				//move to the lower left
				s.push(p);
				p = p.left;
			}
			
			q = null;
			while(!s.isEmpty())
			{
				p = s.pop();
				if(p.right == q)
				{
					/*
					 * if the current node does not have a right child
					 * or the right child has already been visited
					 * we can visit the current node itself
					 */
					result.add(p.val);
					q = p;
				}
				else
				{
					s.push(p);
					/*
					 * since right child has not been visited yet,
					 * we need to process it first
					 */
					p = p.right;
					break;
				}
			}
		}
		while(!s.isEmpty());
		
		return result;
	}
}
