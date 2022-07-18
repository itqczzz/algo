package tree;

/**
 * https://leetcode.cn/problems/path-sum/
 */
public class HasPathSumSolution {
    /**
     * 路径和
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        targetSum = targetSum - root.val;
        if(root.left == null && root.right == null){
            return targetSum == 0;
        }
        return hasPathSum(root.left,targetSum) || hasPathSum(root.right,targetSum);
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
        HasPathSumSolution hasPathSumSolution = new HasPathSumSolution();
        boolean b = hasPathSumSolution.hasPathSum(root,4);
    }
}
