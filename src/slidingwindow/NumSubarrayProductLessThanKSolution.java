package slidingwindow;

/**
 * 713. 乘积小于 K 的子数组
 */
public class NumSubarrayProductLessThanKSolution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0){
            return 0;
        }
        int left = 0,right = 0;
        int res = 0;
        int sum = 1;
        while (right < nums.length){
            sum = sum * nums[right];
            while (sum >= k){
                sum = sum / nums[left];
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        NumSubarrayProductLessThanKSolution numSubarrayProductLessThanKSolution = new NumSubarrayProductLessThanKSolution();
        int i = numSubarrayProductLessThanKSolution.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0);
        System.out.println(i);
    }
}
