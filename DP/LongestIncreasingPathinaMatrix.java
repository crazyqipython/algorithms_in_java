public class LongestIncreasingPathinaMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                res = Math.max(res, dfs(matrix, i, j, dp, -1));
            }
        }
        
        return res;
    }
    
    public int dfs(int[][] matrix, int i, int j, int[][] dp, int preVal){
        if(i<0 || j<0 || i > matrix.length - 1 || j>matrix[0].length -1 || matrix[i][j] <= preVal)
            return 0;
        
        if(dp[i][j] > 0)
            return dp[i][j];
        
        int temp = 0;
        temp = Math.max(temp, dfs(matrix, i+1, j, dp, matrix[i][j]));
        temp = Math.max(temp, dfs(matrix, i-1, j, dp, matrix[i][j]));
        temp = Math.max(temp, dfs(matrix, i, j+1, dp, matrix[i][j]));
        temp = Math.max(temp, dfs(matrix, i, j-1, dp, matrix[i][j]));
        
        dp[i][j] = temp + 1;
        
        return dp[i][j];
    }
}
