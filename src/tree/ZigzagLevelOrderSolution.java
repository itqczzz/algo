//package tree;
//
//import java.util.ArrayList;
//import java.util.Deque;
//import java.util.LinkedList;
//import java.util.List;
//
//public class ZigzagLevelOrderSolution {
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        ArrayList<List<Integer>> lists = new ArrayList<>();
//        if(root == null){
//            return lists;
//        }
//        Deque<TreeNode> deque = new LinkedList<>();
//        deque.offer(root);
//        Boolean flag = true;
//        while (!deque.isEmpty()){
//            TreeNode node = deque.pollFirst();
//            if(temp.size() == 0){
//                ArrayList<Integer> res = new ArrayList<>();
//                lists.add(res);
//            }
//            res.add(node.val);
//
//        }
//    }
//}
