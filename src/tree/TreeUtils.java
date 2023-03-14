package tree;

import tree.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 根据层次遍历还原二叉树
 */
public class TreeUtils {
    public static TreeNode getTreeByList(Integer[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        List<Integer> numsList = Arrays.stream(nums).collect(Collectors.toList());
        TreeNode root = new TreeNode(numsList.get(0));
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        for (int i = 1; i < numsList.size(); i += 2) {
            TreeNode node = deque.poll();
            if(i < numsList.size()){
                node.left = numsList.get(i) == null ? null : new TreeNode(numsList.get(i));
            }else{
                break;
            }
            if((i + 1) < numsList.size()){
                node.right = numsList.get(i + 1) == null ? null : new TreeNode(numsList.get(i + 1));
            }else {
                break;
            }
            if(node.left != null){
                deque.offer(node.left);
            }
            if(node.right != null){
                deque.offer(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] ints = {10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode treeByList = getTreeByList(ints);
        System.out.println(treeByList);
    }

}
