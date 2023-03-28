package slidingwindow;

public class ContainsNearbyDuplicateSolution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0 , right = 1;
        boolean flag = false;
        while(right < nums.length){
            if(nums[left] == nums[right] && Math.abs(right - left) < k){
                flag = true;
                break;
            }
            while ((right - left) > k && nums[right] != nums[left]){
                left++;
            }
            right++;
        }
        return flag;
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicateSolution containsNearbyDuplicateSolution = new ContainsNearbyDuplicateSolution();
        boolean b = containsNearbyDuplicateSolution.containsNearbyDuplicate(new int[]{1,2,3,1}, 3);
        System.out.println(b);
    }
}
