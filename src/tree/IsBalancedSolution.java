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
        if(root == null){
            return false;
        }
        int heightTreeNode = heightTreeNode(root);
        if(heightTreeNode > 1){
            return false;
        }
        return true;
    }

    public int heightTreeNode(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightTreeNode(root.left);
        int rightHeight = heightTreeNode(root.right);
        return Math.abs(leftHeight-rightHeight);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
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
