package DP.linearDP;
import java.util.*;
public class PerfectSquares {
    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 10 ^ 4);

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            int j = 0;
            while (j * j <= i) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                j++;
            }
        }

        return dp[n];
    }
}
