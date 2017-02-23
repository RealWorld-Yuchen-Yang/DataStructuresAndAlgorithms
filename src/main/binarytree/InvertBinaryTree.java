package main.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yucheny on 2/21/17.
 */
public class InvertBinaryTree
{
    public static TreeNode levelOrderTraversalSolution(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null)
            q.offer(root);

        while(!q.isEmpty())
        {
            TreeNode node = q.poll();

            //swap left and right
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if(node.left != null)
                q.offer(node.left);
            if(node.right != null)
                q.offer(node.right);
        }

        return root;
    }
}
