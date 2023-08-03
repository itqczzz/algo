package array;

import java.util.Deque;
import java.util.LinkedList;

public class Trap {

    /**
     * 优化，利用双指针，在找
     * @param height
     * @return
     */
    public int trap1(int[] height){
        if(height == null || height.length == 0){
            return 0;
        }
        int l = 0;
        int r = height.length-1;
        int lMax = 0;
        int rMax = 0;
        int ans = 0;
        for (;l < r;){
            if(height[l] < height[r]){
                if(height[l] >= lMax){
                    lMax = height[l];
                }else{
                    ans += lMax - height[l];
                }
                l++;
            }else{
                if(height[r] >= rMax){
                    rMax = height[r];
                }else{
                    ans += rMax - height[r];
                }
                r--;
            }
        }
        return ans;
    }


    /**
     * 暴力解法
     * 对于每个对应位置，找出左侧最大值和右侧最大值，然后找出左侧最大值和右侧最大值的最小值的比较小的，减去本身的高度
     */
    public int trap2(int[] height) {
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax = minValueBetweenLR(height,0,i);
            rightMax = minValueBetweenLR(height,i,height.length-1);
            res += Math.min(leftMax,rightMax) - height[i];
        }
        return res;
    }

    /**
     * 寻找区间的最大值
     * @param height
     * @param start
     * @param end
     * @return
     */
    public int minValueBetweenLR(int[] height,int start,int end){
        int max = 0;
        for (int i = start; i <= end; i++) {
            max = Math.max(height[i],max);
        }
        return max;
    }

    /**
     * 单调栈解法
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * 动态规划
     * @param height
     * @return
     */
    public int trap4(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // 计算左侧最大高度
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // 计算右侧最大高度
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // 计算每个柱子上的雨水量，并累加结果
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }



    public static void main(String[] args) {
        Trap trap = new Trap();
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap1 = trap.trap4(nums);
        System.out.println(trap1);
    }
}
