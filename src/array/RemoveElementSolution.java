package array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RemoveElementSolution {
    /**
     * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/remove-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param val
     * @return
     */
    /**
     * 思路 ：快慢指针，快指针在前面跑遇到val值停下
     * @param nums
     * @param val
     * @return
     *
     * 3,2,2,3   val = 3
     * 2323
     * 2233
     * 2233
     * 3222
     *
     * 23232323
     * 22332323
     *
     *
     * 2,2,3,3
     */
    public int removeElement(int[] nums, int val) {
        int insertPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[insertPosition++] = nums[i];
            }
        }
        return insertPosition;
    }

    public static void main(String[] args) {
        RemoveElementSolution removeElementSolution = new RemoveElementSolution();
        int[] nums = {3,2,2,3};
        removeElementSolution.removeElement(nums,3);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
