package DP.stringDP;

public class DistinctSubsequences{
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(s, t, 0, 0, dp);
    }

    public int dfs(String s, String t, int i, int j, int[][] dp) {

        if (j == t.length())
            return 1;

        if (i == s.length())
            return 0;

        if (dp[i][j] >= 0)
            return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = dfs(s, t, i + 1, j + 1, dp) + dfs(s, t, i + 1, j, dp);
        } else {
            dp[i][j] = dfs(s, t, i + 1, j, dp);
        }

        return dp[i][j];
    }
}