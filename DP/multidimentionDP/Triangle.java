public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();

        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);

        for(int i=1; i<n; i++){
            int row_len = triangle.get(i).size();
            for(int j=0; j<row_len; j++){

                if(j==0) dp[i][j] = triangle.get(i).get(j) + dp[i-1][j];

                else if(j == row_len - 1){
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            res = Math.min(dp[n-1][i], res);
        }

        return res;
    }
}
