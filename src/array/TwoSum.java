package array;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] res = new int[2];
        while(left < right){
            if((numbers[left] + numbers[right]) > target){
                right--;
            }
            if((numbers[left] + numbers[right]) < target){
                left++;
            }
            if((numbers[left] + numbers[right]) == target){
                res[0] = left;
                res[1] = right;
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum.twoSum(nums, target);
    }
}
