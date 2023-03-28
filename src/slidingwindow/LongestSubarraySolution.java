package slidingwindow;

public class LongestSubarraySolution {
    /**
     * 1493. 删掉一个元素以后全为 1 的最长子数组
     * @param nums
     * @return
     */
    public int longestSubarray(int[] nums) {
        int left = 0,right = 0;
        int res = 0;
        while (right < nums.length){
            if(nums[left] != nums[right]){
                nums[left] = nums[right];
                left++;
                Math.max(res,right - left);
            }
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubarraySolution longestSubarraySolution = new LongestSubarraySolution();
        int[] nums = {1,1,0,1};
        int res = longestSubarraySolution.longestSubarray(nums);
        System.out.println(res);
    }
}
