package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *114. 二叉树展开为链表
 */
public class FlattenSolution {
    public void flatten(TreeNode root) {
        //dummy
        List<TreeNode> treeNodes = preOrderTraversal(root);
        for (int i = 1; i < treeNodes.size(); i++) {
            TreeNode prev = treeNodes.get(i-1);
            TreeNode cur = treeNodes.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }


    public List<TreeNode> preOrderTraversal(TreeNode root){
        List<TreeNode> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node);
            if (node.right!=null){
                stack.add(node.right);
            }
            if(node.left!=null){
                stack.add(node.left);
            }
        }
        return result;
    }
}
