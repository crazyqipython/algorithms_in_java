public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if(s3.length() != s1.length() + s2.length()) return false;
        
        return dfs(s1, s2, s3, 0, 0);
    }
    
    public boolean dfs(String s1, String s2, String s3, int i, int j){
        if(s1.length() == i && s2.length() == j)
            return true;
        
        if(i<s1.length() && s1.charAt(i) == s3.charAt(i+j) && dfs(s1, s2, s3, i+1, j))
            return true;
        
        if(j<s2.length() && s2.charAt(j) == s3.charAt(i+j) && dfs(s1, s2, s3, i, j+1))
            return true;
        
        return false;
    }

    public boolean isInterleave1(String s1, String s2, String s3) {

        if (s3.length() != s1.length() + s2.length())
            return false;

        int n1 = s1.length(), n2 = s2.length();
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];

        for (int i = n1; i >= 0; i--) {
            for (int j = n2; j >= 0; j--) {
                dp[i][j] = false;
            }
        }

        dp[n1][n2] = true;

        for (int i = n1; i >= 0; i--) {
            for (int j = n2; j >= 0; j--) {
                if (i < n1 && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j])
                    dp[i][j] = true;

                if (j < n2 && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1])
                    dp[i][j] = true;
            }
        }

        return dp[0][0];
    }
    
}
