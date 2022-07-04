package tree;

import java.util.Queue;

/**
 * 翻转二叉树
 * https://leetcode.cn/problems/invert-binary-tree/
 */
public class InvertTreeSolution {
    /**
     * 思路：
     * 1. 用前序遍历实现
     * 2. 实现swap函数交换节点引用，然后前序遍历，交换即可
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        //base check
        if(root==null) return null;
        if(root.left!=null) invertTree(root.left);
        if(root.right!=null) invertTree(root.right);
        swap(root);
        return root;
    }



    public void swap(TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
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
        InvertTreeSolution invertTreeSolution = new InvertTreeSolution();
        invertTreeSolution.invertTree(root);
        System.out.println(root);
    }

}
