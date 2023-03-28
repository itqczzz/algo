package array;

public class RemoveDuplicatesSolution {
    /**
     * 26. 删除有序数组中的重复项
     * @param nums
     *
     * 输入：nums = [1,1,2]
     *
     * 1 1 1 2 2
     * 1 2 _ _ _
     *
     */
    public int removeDuplicates(int[] nums) {
        int fastIndex = 0,slowIndex = 0;
        while (fastIndex < nums.length){
            if(nums[fastIndex] != nums[slowIndex]){
                nums[slowIndex + 1] = nums[fastIndex];
                slowIndex++;
            }
            fastIndex++;
        }
        return slowIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicatesSolution removeDuplicatesSolution = new RemoveDuplicatesSolution();
        int i = removeDuplicatesSolution.removeDuplicates(nums);
        System.out.println(i);
    }
}
