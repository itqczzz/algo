package tree;

/**
 * https://leetcode.cn/problems/balanced-binary-tree/
 */
public class IsBalancedSolution {
    /**
     * 后序遍历实现
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return heightTreeNode(root) != -1;
    }

    public int heightTreeNode(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightTreeNode(root.left);
        if(leftHeight == -1){
            return -1;
        }
        int rightHeight = heightTreeNode(root.right);
        if (rightHeight == -1){
            return -1;
        }
        int abs = Math.abs(leftHeight - rightHeight);
        if(abs > 1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight) + 1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        IsBalancedSolution isBalancedSolution = new IsBalancedSolution();
        isBalancedSolution.isBalanced(root);
        System.out.println(root);
    }

}
