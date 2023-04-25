package array;

public class CanJump2 {
    //贪心
    public int jump(int[] nums) {
        int n = nums.length;
        if(n==1){
            return 0;
        }
        int jumps = 0;
        int cur = 0;
        int maxJump = 0;
        for (int i = 0; i < n; i++) {
            //更新到达的最大的地方
            maxJump = Math.max(nums[i]+i,maxJump);
            if(cur == i){
                cur = maxJump;
                jumps++;
                if(cur>=n-1){
                    return jumps;
                }
            }
        }
        return jumps;
    }

    //动态规划 dp[i]代表跳到i位置最少需要跳几次
    public int jump2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        //初始化
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if(dp[j] != Integer.MAX_VALUE && (nums[j] + j) >= i){
                    dp[i] = Math.min(dp[i],dp[j] + 1);
                }
            }
        }
        return dp[n-1];
    }

        public static void main(String[] args) {
        CanJump2 canJump2 = new CanJump2();
        int[] nums = new int[]{2,3,0,1,4};
        int jump = canJump2.jump2(nums);
        System.out.println(jump);
    }
}
