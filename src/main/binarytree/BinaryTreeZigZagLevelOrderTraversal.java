package main.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, say
 * 			3
 * 		  /   \
 * 		9		20
 * 			   /  \
 * 			15		7
 * [
 * 	[3],
 *  [20, 9]
 *  [15, 7]
 * ]
 * 
 * Analysis: 
 * 	This is Width First Traversal. 
 *  Also use a boolean to represent the odd/even of a row
 *  say: 
 *  	odd: true
 *  	even: false
 * @author yuchenyang
 *
 */
public class BinaryTreeZigZagLevelOrderTraversal {
	//solution1: recursive
	public static List<List<Integer>> recursiveSolution(TreeNode root)
	{
		List<List<Integer>> result = new ArrayList();
		traverse(root, 1, result, true);
		return result;
	}
	
	private static void traverse(TreeNode root, int level, List<List<Integer>> result, boolean isOdd)
	{
		if(root == null)
			return;
		if(level > result.size())
			result.add(new ArrayList());
		if(isOdd)
			result.get(level - 1).add(root.val);
		else
			result.get(level - 1).add(0, root.val);
		
		traverse(root.left, level + 1, result, !isOdd);
		traverse(root.left, level + 1, result, !isOdd);
	}
	
	public static List<List<Integer>> iterativeSolution(TreeNode root)
	{
		List result = new ArrayList();
		Queue<TreeNode> current = new LinkedList();
		Queue<TreeNode> next= new LinkedList();
		boolean isOdd = true;
		
		if(root == null)
		{
			return result;	
		}
		else
		{
			current.offer(root);
		}
		
		while(!current.isEmpty())
		{
			ArrayList<Integer> level = new ArrayList();//represents elements in a level
			while(!current.isEmpty())
			{
				TreeNode node = current.poll();
				level.add(node.val);
				//at the main time, construct the next level
				if(node.left != null) 
					next.offer(node.left);				
				if(node.right != null) 
					next.offer(node.right);
			}
			
			//now it is time to construct the int[] representation of the level
			if(!isOdd)
				Collections.reverse(level);
			result.add(level);
			
			//move on to the next level
			isOdd = !isOdd;
			Queue tmp = current;
			current = next;
			next = tmp;	
		}

		return result;
	}
}


