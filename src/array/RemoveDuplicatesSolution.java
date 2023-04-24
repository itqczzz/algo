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
        int cur = 1;
        int repeatCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] == nums[i]){
                repeatCount++;
            }else{
                repeatCount = 1;
            }
            if(repeatCount<=2){
                nums[cur++] = nums[i];
            }
        }
        return cur;
    }

    public int removeDuplicates3(int[] nums) {
        if(nums.length <= 2){
            return nums.length;
        }
        int slow = 1;
        for (int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[slow-1]){
                nums[++slow] = nums[i];
            }
        }
        return slow+1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        RemoveDuplicatesSolution removeDuplicatesSolution = new RemoveDuplicatesSolution();
        int i = removeDuplicatesSolution.removeDuplicates3(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
//        System.out.println(i);
    }
}
