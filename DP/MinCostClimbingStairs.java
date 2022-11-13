import java.util.*;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        
        if(cost == null) return 0;
        
        int n = cost.length;
        
        if(n == 1) return cost[0];
        
        if(n == 2) return Math.min(cost[0], cost[1]);
        
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        
        return Math.min(helper(cost, n-1, memo), helper(cost, n-2, memo));
    }
    
    public int helper(int[] cost, int index, HashMap<Integer, Integer> memo){
        
        if(memo.containsKey(index)) return memo.get(index);
        
        if(index<0) return 0;
        
        if(index==0) {
            memo.put(index, cost[index]);
            return cost[index];
        }
        
        
        memo.put(index, cost[index] + Math.min(helper(cost, index-1, memo), helper(cost, index-2, memo)));
        return memo.get(index);
    }

    public int minCostClimbingStairs1(int[] cost) {

        if (cost == null)
            return 0;

        int n = cost.length;

        if (n == 1)
            return cost[0];

        int[] dp = new int[n];

        dp[0] = cost[0];

        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
