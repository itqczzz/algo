package tree;

import java.util.*;

public class BFSTree {

    public static List<List<Integer>> resList = new ArrayList<List<Integer>>();

    //BFS--递归方式
    public static void checkFun01(TreeNode node, Integer deep) {
        if (node == null) return;
        deep++;

        if (resList.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);

        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }

    //BFS--迭代方式--借助队列
    public static void checkFun02(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            int len = que.size();

            while (len > 0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
                len--;
            }

            resList.add(itemList);
        }

    }

    /**
     * 队列实现层次遍历
     * @param root
     */
    public static void BFS(TreeNode root){
        //base check
        if(root==null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            //探查队列中的元素
            List<Integer> tempList = new ArrayList<>();
            int size = queue.size();
            while(size>0){
                TreeNode tempNode = queue.poll();
                tempList.add(tempNode.val);
                if(tempNode.left!=null) queue.add(tempNode.left);
                if(tempNode.right!=null) queue.add(tempNode.right);
                size--;
            }
            resList.add(tempList);
        }

    }

    /**
     * 递归方式实现树的层次遍历
     * @param root
     */
    public static void BFS(TreeNode root,int deep){
        //base check
        if(root == null){
            return;
        }
        deep++;
        if(resList.size()<deep){
            List<Integer> tempList = new ArrayList<>();
            resList.add(tempList);
        }
        resList.get(deep-1).add(root.val);
        BFS(root.left,deep);
        BFS(root.right,deep);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        root.left = left;
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        TreeNode right = new TreeNode(2);
        root.right = right;
        right.left = new TreeNode(5);
        right.right = new TreeNode(6);
        BFS(root,0);
        resList.forEach(System.out::println);
    }
}
