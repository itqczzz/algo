package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathSumSolution {
    List<List<Integer>> ret = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum);
        return ret;
    }

    public void dfs(TreeNode root,int targetSum){
        if(root == null){
            return;
        }
        targetSum -= root.val;
        path.addLast(root.val);
        if(root.left == null && root.right == null && targetSum == 0){
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
        path.pollLast();
    }
}
