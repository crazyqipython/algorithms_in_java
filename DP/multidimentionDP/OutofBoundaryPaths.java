class OutofBoundaryPaths{
    private int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        int mod = (int) 1e9 + 7;

        for (int k = 1; k < maxMove + 1; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] d : dirs) {
                        int x = i + d[0], y = j + d[1];
                        if (x < 0 || x >= m || y < 0 || y >= n) {
                            dp[i][j][k] = (dp[i][j][k] + 1) % mod;
                        } else {
                            dp[i][j][k] = (dp[i][j][k] + dp[x][y][k - 1]) % mod;
                        }
                    }
                }
            }
        }

        return dp[startRow][startColumn][maxMove];
    }
}