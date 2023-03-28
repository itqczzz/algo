package array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RemoveElementSolution {

    public int removeElement(int[] nums, int val) {
        int fastIndex = 0,slowIndex = 0;
        while (fastIndex < nums.length){
            if(nums[fastIndex] != val){
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
            fastIndex++;
        }
        return slowIndex;
    }



    public static void main(String[] args) {
        RemoveElementSolution removeElementSolution = new RemoveElementSolution();
        int[] nums = {3,2,2,3};
        int i = removeElementSolution.removeElement(nums, 3);
        System.out.println(i);
    }
}
