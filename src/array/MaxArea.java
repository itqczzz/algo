package array;

public class MaxArea {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for(int i = 0;i < height.length;i++){
            for(int j = i + 1;j < height.length;j++){
                maxArea = Math.max(maxArea,Math.min(height[i],height[j])*(j-i));
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // 计算面积
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));

            // 移动较短的指针
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int[] nums = {1,2,1};
        //1 2 1
        //0 1 2
        //1 2 1/3
        //0 2 2
        int maxAreaValue = maxArea.maxArea2(nums);
        System.out.println(maxAreaValue);
    }
}
