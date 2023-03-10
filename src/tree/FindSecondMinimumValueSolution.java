package tree;

/**
 * 671. 二叉树中第二小的节点
 */
public class FindSecondMinimumValueSolution {
    int ans;
    int rootValue;

    public int findSecondMinimumValue(TreeNode root) {
        ans = -1;
        rootValue = root.val;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return ;
        }
        if(ans != -1 && root.val >= ans){
            return;
        }
        if(root.val > rootValue){
            ans = root.val;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
