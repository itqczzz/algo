package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepthSolution {
    /**
     * 思路：1.中序 左中右
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth,rightMaxDepth)+1;
    }

    /**
     * 迭代法层序遍历
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int deepth = 0;
        while(!deque.isEmpty()){
            deepth++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if(node.left!=null){
                    deque.offer(node.left);
                }
                if(node.right!=null){
                    deque.offer(node.right);
                }
            }
        }
        return deepth;
    }

        public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        left.right = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        root.right = right;
        right.right = new TreeNode(3);
        MaxDepthSolution maxDepthSolution = new MaxDepthSolution();
        int maxDepth = maxDepthSolution.maxDepth(root);
        System.out.println(maxDepth);
    }
}
