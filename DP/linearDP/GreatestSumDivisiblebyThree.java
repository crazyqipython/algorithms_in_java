class GreatestSumDivisiblebyThree{
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][3];
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        for(int i=1; i<n+1; i++){
            if(nums[i-1] % 3 == 0){
                dp[i][0] = Math.max(dp[i-1][0], nums[i-1] + dp[i-1][0]);
                dp[i][1] = Math.max(dp[i-1][1], nums[i-1] + dp[i-1][1]);
                dp[i][2] = Math.max(dp[i-1][2], nums[i-1] + dp[i-1][2]);
            }
            else if(nums[i-1] % 3 == 1){
                dp[i][0] = Math.max(dp[i-1][0], nums[i-1] + dp[i-1][2]);
                dp[i][1] = Math.max(dp[i-1][1], nums[i-1] + dp[i-1][0]);
                dp[i][2] = Math.max(dp[i-1][2], nums[i-1] + dp[i-1][1]);
            }
            else{
                dp[i][0] = Math.max(dp[i-1][0], nums[i-1] + dp[i-1][1]);
                dp[i][1] = Math.max(dp[i-1][1], nums[i-1] + dp[i-1][2]);
                dp[i][2] = Math.max(dp[i-1][2], nums[i-1] + dp[i-1][0]);
            }
        }
        return dp[n][0];
    }
}