package main.binarytree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yucheny on 2/21/17.
 */
public class LevelOrderTraversal
{
    public static List<List<Integer>> recursiveImp(TreeNode root)
    {
        List<List<Integer>> result = new LinkedList<>();
        recursiveImp(root, 1, result);
        return result;
    }

    /**
     * The gist of LevelOrderTraversal is to use a queue
     * for each level nodes
     * enqueue and dequeue
     * @param root
     * @return
     */
    public static List<List<Integer>> inReverseOrder(TreeNode root)
    {
        List<List<Integer>> result =  recursiveImp(root);
        Collections.reverse(result);
        return result;
    }

    public static void recursiveImp(TreeNode root, int level, List<List<Integer>> result)
    {
        if(root == null)
            return;
        if(level>result.size())
            result.add(new LinkedList<>());

        result.get(level-1).add(root.val);
        recursiveImp(root.left, level + 1, result);
        recursiveImp(root.right, level+1, result);
    }
}
