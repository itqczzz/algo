package array;

public class MaxSumTwoNoOverlap {
    /**
     * 目标 求出两个练习子数组的最大和
     * 子问题  分别求出每个连续子数组的最大和，前提是边界不相交
     * @param nums
     * @param firstLen
     * @param secondLen
     * @return
     */
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        // 计算前缀和数组
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int ans = 0;
        // 遍历数组，找到长度为 firstLen 和 secondLen 的子数组
        for (int i = 0; i <= n - firstLen - secondLen; i++) {
            // 计算两个子数组的和，并更新最大和
            ans = Math.max(ans, maxSum(prefixSum, firstLen, i) + maxSum(prefixSum, secondLen, i + firstLen));
            ans = Math.max(ans, maxSum(prefixSum, secondLen, i) + maxSum(prefixSum, firstLen, i + secondLen));
        }

        // 返回最大和
        return ans;
    }

    /**
     * 辅助函数，计算从 start 索引开始，长度为 len 的子数组的最大和
     *
     * @param prefixSum 前缀和数组
     * @param len 子数组长度
     * @param start 开始索引
     * @return 最大和
     */
    private int maxSum(int[] prefixSum, int len, int start) {
        int maxSum = 0;
        // 遍历数组，找到长度为 len 的子数组
        for (int i = start; i <= prefixSum.length - len - 1; i++) {
            // 计算子数组的和，并更新最大和
            maxSum = Math.max(maxSum, prefixSum[i + len] - prefixSum[i]);
        }
        return maxSum;
    }

}
