package tree;

public class SearchBSTSolution {
    /**
     * 二叉搜索树
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        if(root.val < val){
            return searchBST(root.right,val);
        }
        if(root.val > val){
            return searchBST(root.left,val);
        }
        return null;
    }

}
