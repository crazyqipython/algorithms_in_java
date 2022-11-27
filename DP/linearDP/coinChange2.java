package DP.linearDP;
import java.util.*;

public class coinChange2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);

        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 0; i < amount + 1; i++) {
                if (i - coin >= 0)
                    dp[i] = dp[i] + dp[i - coin];
            }
        }

        return dp[amount];
    }
}
