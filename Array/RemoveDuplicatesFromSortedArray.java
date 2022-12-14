package Array;
import java.util.*;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        for(int j = 1; j<nums.length; j++){
            if(nums[i] == nums[j]){
                continue;
            }else{
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        return i+1;
    }
}


/*
 * public int removeDuplicates(int[] nums) {
 * int i = 0;
 * for(int n : nums)
 * if(i < 1 || n > nums[i - 1])
 * nums[i++] = n;
 * return i;
 * }
 */