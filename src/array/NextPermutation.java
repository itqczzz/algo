package array;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 从后向前查找第一个升序对
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 如果找到升序对
        if (i >= 0) {
            int j = nums.length - 1;
            // 从后向前查找第一个比 nums[i] 大的元素
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            // 交换 nums[i] 和 nums[j]
            swap(nums, i, j);
        }

        // 反转 i 之后的子数组
        reverse(nums, i + 1, nums.length - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = {1,3,2};
        nextPermutation.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
