import java.util.*;

public class MinimumNumberofTapstoOpentoWateraGarden{
    public int minTaps(int n, int[] ranges) {
        int l = ranges.length;
        int[] dp = new int[l];

        Arrays.fill(dp, l+1);
        dp[0] = 0;

        for(int i=0; i<l; i++){
            int start = Math.max(0, i-ranges[i]);
            int end = Math.min(l-1, i+ranges[i]);
            for(int j=start+1; j<=end; j++){
                dp[j] = Math.min(dp[j], dp[start] + 1);
            }
        }

        return dp[l-1] == l+1 ? -1 : dp[l-1];

    }
}