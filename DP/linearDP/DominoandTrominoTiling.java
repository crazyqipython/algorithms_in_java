package DP.linearDP;

public class DominoandTrominoTiling {
    private int MOD = 1000000007;

    public int numTilings(int n) {
        int[][] dp = new int[1001][2];
        return solve(0, n, dp, 0);
    }

    public int solve(int i, int n, int[][] dp, int preGap) {
        if (i > n)
            return 0;

        if (i == n) {
            if (preGap == 1)
                return 0;
            else
                return 1;
        }
        if (dp[i][preGap] > 0)
            return dp[i][preGap];

        if (preGap == 1) {
            dp[i][preGap] = solve(i + 1, n, dp, 0) % MOD + solve(i + 1, n, dp, 1) % MOD;
        } else {
            dp[i][preGap] = solve(i + 1, n, dp, 0) % MOD + solve(i + 2, n, dp, 0) % MOD
                    + 2 * solve(i + 2, n, dp, 1) % MOD;
        }
        return dp[i][preGap];
    }
}
