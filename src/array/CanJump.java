package array;

public class CanJump {
        public boolean canJump(int[] nums) {
            int maxJump = 0;
            for (int i = 0; i < nums.length; i++) {
                if(i > maxJump){
                    return false;
                }
                maxJump = Math.max(maxJump,nums[i] + i);
            }
            return true;
        }

        public boolean canJump2(int[] nums) {
            int n = nums.length;
            boolean[] dp = new boolean[n];
            dp[0] = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if(dp[j] && j+nums[j] >= i){
                        dp[i] = true;
                    }
                }
            }
            return dp[n-1];
        }


    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        int[] nums = new int[]{2,3,1,1,4};
        boolean b = canJump.canJump(nums);
        System.out.println(b);
    }

}
