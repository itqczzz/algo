package array;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //数组排序
        Arrays.sort(nums);
        //数组处理到set中
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        //双指针查找
        int pre = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if((nums[i] + nums[j]) == pre){
                    continue;
                }
                int target = 0 - (nums[i] + nums[j]);
                if(set.contains(target) && (nums[i] != nums[j]) && (nums[j] <= target)){
                    List<Integer> targetList = new ArrayList<>();
                    targetList.add(nums[i]);
                    targetList.add(nums[j]);
                    targetList.add(target);
                    list.add(targetList);
                    pre = target;
                }
            }
        }
        return list;
    }
}
