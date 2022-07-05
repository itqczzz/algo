package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/symmetric-tree/
 */
public class IsSymmetricSolution {
    /**
     * 思路：DFS 后序遍历 ，两次遍历，一个中左右，一个中右左，对比遍历元素是否相等
     * 1.
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return compareNode(root.left,root.right);
    }


    public boolean compareNode(TreeNode left,TreeNode right){
        if(left == null&& right == null){
            return true;
        }
        if(left !=null && right == null){
            return false;
        }
        if(left == null && right != null){
            return false;
        }
        if(left !=null && right != null && left.val != right.val){
            return false;
        }
        boolean outSide = compareNode(left.left, right.right);
        boolean innerSide = compareNode(left.right, right.left);
        return outSide && innerSide;
    }

    /**
     * 双端遍历法
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()){
            TreeNode left = deque.pollFirst();
            TreeNode right = deque.pollLast();
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null || left.val != right.val){
                return false;
            }
            deque.offerFirst(left.left);
            deque.offerFirst(left.right);
            deque.offerLast(right.right);
            deque.offerLast(right.left);
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        left.right = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        root.right = right;
        right.right = new TreeNode(3);
        IsSymmetricSolution isSymmetricSolution = new IsSymmetricSolution();
        boolean symmetric = isSymmetricSolution.isSymmetric2(root);
        System.out.println(symmetric);
    }
}
