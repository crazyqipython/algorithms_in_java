

import java.util.*;

public class FirstMissingPositive{
    public int FirstMissingPositive(int[] nums){

        int n = nums.length;

        for(int i = 0; i<n; i++){
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                swap(nums, i, nums[i] - 1);
            }
        }

        for(int i=0; i<n; i++){
            if(nums[i] != i+1) return i+1;
        }

        return n+1;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}