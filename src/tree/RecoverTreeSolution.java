package tree;

public class RecoverTreeSolution {
    // 分别记录这两个被交换的节点
    TreeNode first = null, second = null;
    // 判断中序遍历的有序性
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);


    public void recoverTree(TreeNode root) {
        inorderTraverse(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);
        // 中序遍历代码位置，找出那两个节点
        if (root.val < prev.val) {
            // root 不符合有序性
            if (first == null) {
                // 第一个错位节点是 prev
                first = prev;
            }
            // 第二个错位节点是 root
            second = root;
        }
        prev = root;
        inorderTraverse(root.right);
    }

}
