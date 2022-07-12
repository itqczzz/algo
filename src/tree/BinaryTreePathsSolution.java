package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/binary-tree-paths/
 */
public class BinaryTreePathsSolution {
    /**
     * 思路：递归+回溯
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        backtracking(root,res,paths);
        return res;
    }

    /**
     * 回溯确定终止条件为 左右节点都为空，说明到达叶子节点了
     * @param root
     * @param res
     * @param paths
     */
    public void backtracking(TreeNode root, List<String> res, List<Integer> paths) {
        paths.add(root.val);
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size()-1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size()-1));
            res.add(sb.toString());
            return;
        }
        if(root.left != null){
            backtracking(root.left,res,paths);
            paths.remove(paths.size()-1);
        }
        if(root.right != null){
            backtracking(root.right,res,paths);
            paths.remove(paths.size()-1);
        }
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        stack.push(root.val+"");
        while (!stack.isEmpty()){
            String path = (String)stack.pop();
            TreeNode node = (TreeNode)stack.pop();
            if(node.left == null && node.right == null){
                res.add(path);
            }
            if(node.left != null){
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
            if(node.right != null){
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }
        }
        return res;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        root.left = left;
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        TreeNode right = new TreeNode(2);
        root.right = right;
        right.left = new TreeNode(5);
        right.right = new TreeNode(6);
        BinaryTreePathsSolution binaryTreePathsSolution = new BinaryTreePathsSolution();
        List<String> res = binaryTreePathsSolution.binaryTreePaths1(root);
        res.forEach(System.out::println);
    }
}
