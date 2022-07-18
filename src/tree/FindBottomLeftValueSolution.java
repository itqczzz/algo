package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/find-bottom-left-tree-value/
 */
public class FindBottomLeftValueSolution {
    int MAX_DEEP = -1;
    int result = -1;
    /**
     * 迭代法
     * @param root
     * @return
     */
    public int findBottomLeftValue1(TreeNode root) {
        result = root.val;
        findBottomLeftValue(root,0);
        return result;
    }

    public void findBottomLeftValue(TreeNode root,int deep) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(deep > MAX_DEEP){
                result = root.val;
                MAX_DEEP = deep;
            }
        }
        if(root.left != null){
            findBottomLeftValue(root.left,deep+1);
        }
        if(root.right != null){
            findBottomLeftValue(root.right,deep+1);
        }
    }
        /**
         * 层序遍历
         * @param root
         * @return
         */
    public int findBottomLeftValue(TreeNode root) {
        if(root == null){
            return 0;
        }
        int result = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(i == 0){
                    result = node.val;
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
}
