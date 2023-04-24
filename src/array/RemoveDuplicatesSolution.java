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

    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 1;
        int uniqueCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[uniqueCount] = nums[i];
                uniqueCount++;
            }
        }

        return uniqueCount;
    }



    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,1,2,3,3};
        RemoveDuplicatesSolution removeDuplicatesSolution = new RemoveDuplicatesSolution();
        int i = removeDuplicatesSolution.removeDuplicates2(nums);
        for (int num : nums) {
            System.out.println(num);
        }
//        System.out.println(i);
    }
}
