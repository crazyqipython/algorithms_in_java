package DP.linearDP;
import java.util.*;
public class UniqueBinarySearchTrees {

    private Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public int numTrees1(int n) {
        if (n <= 1)
            return 1;

        if (cache.containsKey(n))
            return cache.get(n);

        int res = 0;
        for (int i = 1; i < n + 1; i++) {
            res = res + numTrees(i - 1) * numTrees(n - i);
        }

        cache.put(n, res);
        return res;
    }

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        
        Arrays.fill(dp, 0);
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i<n+1; i++){
            for(int j=1; j<=i; j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        
        return dp[n];
    }


}

