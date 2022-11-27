package DP.internalDP;
class BurstBalloons{
    public int maxCoins(int[] nums) {
        int[] inums = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) {
            if (x > 0) {
                inums[n] = x;
                n++;
            }
        }
        inums[0] = 1;
        inums[inums.length - 1] = 1;

        int[][] dp = new int[inums.length][inums.length];

        return dfs(inums, 1, inums.length - 2, dp);

    }

    public int dfs(int[] nums, int l, int r, int[][] dp) {

        if (l > r)
            return 0;

        if (dp[l][r] > 0)
            return dp[l][r];

        dp[l][r] = 0;
        for (int i = l; i < r + 1; i++) {
            int coins = nums[l - 1] * nums[i] * nums[r + 1];
            coins = coins + dfs(nums, l, i - 1, dp) + dfs(nums, i + 1, r, dp);
            dp[l][r] = Math.max(dp[l][r], coins);
        }

        return dp[l][r];
    }
}