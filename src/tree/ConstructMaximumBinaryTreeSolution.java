package tree;

/**
 * https://leetcode.cn/problems/maximum-binary-tree/
 */
public class ConstructMaximumBinaryTreeSolution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums,0,nums.length-1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums,int left,int right){
        if(left > right){
            return null;
        }
        if(left == right){
            return new TreeNode(nums[left]);
        }
        int rootIndex = maxNumIndex(nums, left, right);
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = constructMaximumBinaryTree(nums,left,rootIndex-1);
        root.right = constructMaximumBinaryTree(nums,rootIndex+1,right);
        return root;
    }

    public int maxNumIndex(int[] nums,int left,int right){
        int maxIndex = -1;
        int maxNum = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if(nums[i] > maxNum){
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        ConstructMaximumBinaryTreeSolution constructMaximumBinaryTreeSolution = new ConstructMaximumBinaryTreeSolution();
        int[] nums = new int[]{3,2,1,6,0,5};
        TreeNode node = constructMaximumBinaryTreeSolution.constructMaximumBinaryTree(nums);
    }
}
