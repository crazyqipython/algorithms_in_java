package DP.internalDP;
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int len = s.length();
        int res = 0;
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            res++;
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i == 1 || dp[i + 1][j - 1] == true)) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }

        return res;
    }
}
