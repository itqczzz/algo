package array;

import java.util.Arrays;

public class MergeTwoArray {
    //关键词，非递减
    //如何利用非递减的特性，双指针遍历插入
    //解法一 ，合并数组后排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);

    }

    //解法二 new一个新数组，从nums1和nums2取元素，谁小放前面
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m+n];
        int p = 0;
        int q = 0;
        int cur = 0;
        while(p<m&&q<n){
            if(nums1[p] <= nums2[q]) {
                nums[cur++] = nums1[p++];
            }else{
                nums[cur++] = nums2[q++];
            }
        }
        //循环结束后看谁还没有循环完
        while (p<m){
            nums[cur++] = nums1[p++];
        }
        while(q<n){
            nums[cur++] = nums2[q++];
        }

        //复制nums到nums1
        System.arraycopy(nums,0,nums1,0,m+n);
    }

    //解法三 双指针尾插
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p = m-1;
        int q = n-1;
        int cur = m+n-1;
        while (p>=0 && q>=0){
            if(nums1[p] >= nums2[q]){
                nums1[cur--] = nums1[p--];
            }else{
                nums1[cur--] = nums2[q--];
            }
        }
        //如果nums2还有剩余
        while (q>=0){
            nums1[cur--] = nums2[q--];
        }
    }

    public static void main(String[] args) {
        MergeTwoArray mergeTwoArray = new MergeTwoArray();
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        mergeTwoArray.merge3(nums1,3,nums2,3);
        for(int num:nums1){
            System.out.print(num+" ");
        }
    }

}
