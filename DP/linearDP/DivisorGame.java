package DP.linearDP;
import java.util.*;

public class DivisorGame {
    public boolean divisorGame(int n) {
        HashMap<Integer, Boolean> cache = new HashMap<Integer, Boolean>();

        boolean a = dfs(n, true, cache);

        for (Map.Entry<Integer, Boolean> set : cache.entrySet()) {
            if (set.getValue())
                return true;
        }
        return false;
    }

    public boolean dfs(int n, boolean is_a, HashMap<Integer, Boolean> cache) {
        if (n == 1) {

            if (is_a)
                return false;

            else
                return true;
        }

        if (cache.containsKey(n))
            return false;

        for (int i = 1; i * i < n; i++) {
            if (n % i == 0)
                cache.put(n, dfs(n - i, !is_a, cache));
        }

        return false;
    }

    public boolean divisorGame1(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[1] = false;
        dp[0] = false;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    if (!dp[i - j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[n];
    }
}
