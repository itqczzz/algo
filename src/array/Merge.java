package array;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 两个数组均从末尾开始扫描
        // 把较大的元素填充在nums1末尾
        int p = m - 1;
        int q = n - 1;
        int cur = m + n - 1;
        while (p >= 0 && q >= 0) {
            if (nums1[p] > nums2[q]) {
                nums1[cur--] = nums1[p--];
            } else {
                nums1[cur--] = nums2[q--];
            }
        }
        // 当nums1中的元素都被扫描完，但nums2中还有剩余元素时，需要将剩余元素拷贝到nums1中
        while (q >= 0) {
            nums1[cur--] = nums2[q--];
        }
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        Merge merge = new Merge();
        merge.merge(nums1,m,nums2,n);
        for (int i : nums1) {
            System.out.print(i);
        }
    }
}
