package DP.LCS;
class EditDistance{
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n + 1; i++) {
            dp[i][m] = n - i;
        }

        for (int j = 0; j < m + 1; j++) {
            dp[n][j] = m - j;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j))
                    dp[i][j] = dp[i + 1][j + 1];
                else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j + 1]);
                    dp[i][j]++;
                }
            }
        }

        return dp[0][0];
    }
}