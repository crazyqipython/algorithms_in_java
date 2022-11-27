import java.util.*;

public class LongestCommonSubsequence{
    private Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {

        int n1 = text1.length(), n2 = text2.length();
        int[][] res = new int[n1 + 1][n2 + 1];

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    res[i][j] = res[i + 1][j + 1] + 1;
                } else {
                    res[i][j] = Math.max(res[i + 1][j], res[i][j + 1]);
                }
            }
        }

        return res[0][0];
    }

    public int longestCommonSubsequence1(String text1, String text2) {
        dp = new Integer[text1.length()][text2.length()];
        return longestCommonSubsequence(text1, text2, 0, 0);
    }

    private int longestCommonSubsequence(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length())
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        if (text1.charAt(i) == text2.charAt(j))
            return dp[i][j] = 1 + longestCommonSubsequence(text1, text2, i + 1, j + 1);
        else
            return dp[i][j] = Math.max(
                    longestCommonSubsequence(text1, text2, i + 1, j),
                    longestCommonSubsequence(text1, text2, i, j + 1));
    }
}