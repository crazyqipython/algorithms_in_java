package TwoPointers;
import java.util.*;

public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target){
        int res;
        Arrays.sort(nums);
        res = nums[0] + nums[1] + nums[2];

        for(int i=0; i < nums.length - 2; i++){
            
            if(i > 0 && nums[i] == nums[i-1]) continue;
                
            int j = i+1;
            int k = nums.length - 1;

            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];

                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }

                if(sum == target) return target;

                else if(sum > target){
                    k--;
                    //while(k>0 && nums[k] == nums[k+1]) k--;
                }else{
                    j++;
                    //while(j<k && nums[j] == nums[j-1]) j++;
                }
            }
        }

        return res;
    }
}