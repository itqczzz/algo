package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小深度
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 */
public class MinDepthSolution {
    /**
     * 后序递归实现
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }
        // 左右结点都不为null
        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     * 层序遍历实现
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList();
        deque.offer(root);
        int depth = 0;
        while(!deque.isEmpty()){
            depth++;
            int size = deque.size();
            while (size-->0){
                TreeNode node = deque.poll();
                if(node.left == null && node.right == null){
                    return depth;
                }
                if(node.left != null){
                    deque.offer(node.left);
                }
                if(node.right != null){
                    deque.offer(node.right);
                }
            }
        }
        return depth;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        left.right = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        root.right = right;
        MinDepthSolution minDepthSolution = new MinDepthSolution();
        int i = minDepthSolution.minDepth1(root);
        System.out.println(i);
    }
}
