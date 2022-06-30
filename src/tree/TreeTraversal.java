package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {


    public static List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        preOrderTraversal(root,result);
        return result;
    }

    public static void preOrderTraversal(TreeNode root,List<Integer> result){
        if(root==null){
            return;
        }
        result.add(root.val);
        preOrderTraversal(root.left,result);
        preOrderTraversal(root.right,result);
    }


    public static List<Integer> inOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root,result);
        return result;
    }

    public static void inOrderTraversal(TreeNode root,List<Integer> result){
        if(root==null){
            return;
        }
        inOrderTraversal(root.left,result);
        result.add(root.val);
        inOrderTraversal(root.right,result);
    }

    public static List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        postOrderTraversal(root,result);
        return result;
    }

    public static void postOrderTraversal(TreeNode root,List<Integer> result){
        if(root==null){
            return;
        }
        postOrderTraversal(root.left,result);
        postOrderTraversal(root.right,result);
        result.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        List<Integer> integers = postOrderTraversal(treeNode);
        integers.forEach(System.out::println);
    }

}
