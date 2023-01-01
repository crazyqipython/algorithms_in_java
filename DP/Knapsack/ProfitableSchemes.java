public class ProfitableSchemes {
    private int mod = (int) 1e9 + 7;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int l = group.length;
        int[][][] dp = new int[l + 1][n + 1][minProfit + 1];

        dp[0][0][0] = 1;

        for (int k = 1; k <= l; k++) {
            int p = profit[k - 1];
            int g = group[k - 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= minProfit; j++) {
                    dp[k][i][j] = dp[k - 1][i][j];

                    if (i - g >= 0)
                        dp[k][i][j] = (dp[k][i][j] + dp[k - 1][i - g][Math.max(0, j - p)]) % mod;

                }
            }
        }

        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = (sum + dp[l][i][minProfit]) % mod;
        }
        return sum;
    }
}
