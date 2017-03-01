package main.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yucheny on 2/21/17.
 */
public class RightSideView
{
    public static List solve(TreeNode root)
    {
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> current = new LinkedList();
        Queue<TreeNode> next = new LinkedList();

        if(root == null)
        {
            return result;
        }
        else
        {
            current.offer(root);//offer means enqueue. This line puts the root in the current node list
        }

        while(!current.isEmpty())
        {
            List<Integer> level = new LinkedList();
            while(!current.isEmpty())
            {
                //this is a level traversal of the tree
                TreeNode node = current.poll();//dequeue the current node
                level.add(node.val);
                if(node.left != null)
                    next.add(node.left);
                if(node.right !=null)
                    next.add(node.right);
            }
            result.add(level.get(level.size()-1));//add the last element of the current row to the result

            //swap the current<-->next level
            Queue<TreeNode> tmp = current;
            current = next;
            next = tmp;
        }
        return result;
    }
}
