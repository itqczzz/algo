package tree;

/**
 * 437. 路径总和 III
 */
public class PathSumSolution3 {

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int ret = rootSum(root,targetSum);
        ret += pathSum(root.left,targetSum);
        ret += pathSum(root.right,targetSum);
        return ret;
    }

    public int rootSum(TreeNode root,long targetSum){
        int ret = 0;
        if(root == null){
            return 0;
        }
        int val = root.val;
        if(val == targetSum){
            ret++;
        }
        ret += rootSum(root.left,targetSum - val);
        ret += rootSum(root.right,targetSum - val);
        return ret;
    }

    public static void main(String[] args) {
//        [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
//        0
        PathSumSolution3 pathSumSolution3 = new PathSumSolution3();
        TreeNode treeByList = TreeUtils.getTreeByList(new Integer[]{1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000});
        int i = pathSumSolution3.pathSum(treeByList, 0);
        System.out.println(i);
    }
}
