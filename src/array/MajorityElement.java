package array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
//    给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
//
//    你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode.cn/problems/majority-element
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    /**
     * 如果假设大多数元素一定存在，那么设定下表为目标数字的+1，不是目标数字的-1，最后结果一定大于0
     *
     * 输入：nums = [2,2,1,1,1,2,2]
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == null){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()>nums.length/2){
                return entry.getKey();
            }
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }


    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = new int[]{2,2,1,1,1,2,2};
        int i = majorityElement.majorityElement2(nums);
        System.out.println(i);
    }
}
