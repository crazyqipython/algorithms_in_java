public class targetSum {
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, 0, 0, target);
    }
    
    public int backtrack(int[] nums, int i, int total, int target){
        
        if(i==nums.length) return total == target?1:0;
        
        return backtrack(nums, i+1, total+nums[i], target) + backtrack(nums, i+1, total-nums[i], target);
    }
}
