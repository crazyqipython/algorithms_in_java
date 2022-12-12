import java.util.*;

public class MaximumLengthofPairChain {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] dp = new int[n];

        Arrays.fill(dp, 1);
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                else
                    dp[i] = Math.max(dp[i], dp[j]);
            }
        }

        return dp[n - 1];
    }
}