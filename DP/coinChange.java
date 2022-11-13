import java.util.*;
class coinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        
        dp[0] = 0;
        
        for(int i=1; i<amount+1; i++){
            int m = Integer.MAX_VALUE;
            for(int coin: coins){
                if(i - coin >= 0 && dp[i-coin] >= 0)
                    m = Math.min(m, dp[i-coin] + 1);
            }
            dp[i] = m < Integer.MAX_VALUE ? m:-1;
        }
        
        return dp[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        if (amount < 1)
            return 0;
        return helper(coins, amount, new int[amount]);
    }

    private int helper(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]:
                                                            // minimum number of coins to sum up to rem
        if (rem < 0)
            return -1; // not valid

        if (rem == 0)
            return 0; // completed

        if (count[rem - 1] != 0)
            return count[rem - 1]; // already computed, so reuse

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}