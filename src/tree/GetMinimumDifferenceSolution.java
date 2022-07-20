package tree;

/**
 * https://www.programmercarl.com/0530.%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E7%9A%84%E6%9C%80%E5%B0%8F%E7%BB%9D%E5%AF%B9%E5%B7%AE.html#%E9%80%92%E5%BD%92
 */
public class GetMinimumDifferenceSolution {
    int MIN_NUM = Integer.MAX_VALUE;
    /**
     * DFS 前序
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        if(root == null || root.left == null && root.right == null){
            return 0;
        }
        if(root.left != null && Math.abs(root.left.val - root.val) < MIN_NUM){
            MIN_NUM = Math.abs(root.left.val - root.val);
        }
        if(root.right != null && Math.abs(root.right.val - root.val) < MIN_NUM){
            MIN_NUM = Math.abs(root.right.val - root.val);
        }
        return MIN_NUM;
    }
}
