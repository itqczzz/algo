package slidingwindow;

public class LongestOnesSolution {
    public int longestOnes(int[] nums, int k) {
        int left = 0,right = 0;
        int zeroNum = 0;
        int res = 0;
        while (right < nums.length){
            if(nums[right] == 0){
                zeroNum++;
            }
            while (zeroNum > k){
                if(nums[left] == 0){
                    zeroNum -= 1;
                }
                left ++;
            }
            res = Math.max(res,right - left + 1);
            right++;
        }
        return res;
    }
}
