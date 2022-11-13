public class  HouseRobbertwo {
    public int rob(int[] nums) {
        if(nums == null) return 0;
        
        int n = nums.length;
        if(n==1) return nums[0];
        
        if(n==2) return Math.max(nums[0], nums[1]);
        
        return Math.max(helper(nums, 0, n-2), helper(nums, 1, n-1));
    }
                        
    public int helper(int[] nums,int i, int n){
    
        int[] dp = new int[nums.length];
        
        dp[i] = nums[i];
        dp[i+1] = Math.max(nums[i], nums[i+1]);
        
        for(int j = i+2; j<=n; j++){
            dp[j] = Math.max(nums[j]+dp[j-2], dp[j-1]);
        }
        
        return dp[n];
    }                  

}
