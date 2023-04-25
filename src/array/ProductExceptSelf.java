package array;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProduct = new int[n];
        int[] suffixProduct = new int[n];
        int[] answer = new int[n];
        prefixProduct[0] = 1;
        suffixProduct[n-1] = 1;
        for (int i = 1; i < n; i++) {
            prefixProduct[i] = prefixProduct[i-1] * nums[i-1];
        }
        for (int i = n-2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i+1] * nums[i+1];
        }
        for (int i = 0; i < n; i++) {
            answer[i] = prefixProduct[i] * suffixProduct[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        int[] nums = new int[]{1,2,3,4};
        int[] ints = productExceptSelf.productExceptSelf(nums);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

}
