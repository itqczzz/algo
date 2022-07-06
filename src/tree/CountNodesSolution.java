package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/count-complete-tree-nodes/
 */
public class CountNodesSolution {
    public int countNodes(TreeNode root) {
        int count = 0;
        countNodes(root,count);
        return count;
    }

    /**
     * 后序遍历实现
     * @param root
     * @return
     */
    public void countNodes(TreeNode root,int count) {
        if(root == null){
            return;
        }
        count++;
        if(root.left != null){
            countNodes(root.left,count);
        }
        if(root.right != null){
            countNodes(root.right,count);
        }

    }
        /**
         * 层次遍历实现
         * @param root
         * @return
         */
    public int countNodes1(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int count = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size-->0){
                TreeNode node = deque.poll();
                count++;
                if(node.left != null){
                    deque.offer(node.left);
                }
                if(node.right != null){
                    deque.offer(node.right);
                }
            }
        }
        return count;
    }

}
