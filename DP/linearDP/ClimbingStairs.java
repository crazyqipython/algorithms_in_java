package DP.linearDP;

import java.util.*;

public class ClimbingStairs{
    public int climbStairs(int n) {
        if(n==1)
            return n;
        
        return helper(n, new HashMap<Integer, Integer>());
    }
    
    // top down
    public int helper(int n, HashMap<Integer, Integer> d){
        if(d.containsKey(n)) return d.get(n);
        
        if(n==1){
            d.put(1, 1);
            return 1;
        }
        
        if(n==2){ 
            d.put(2, 2);
            return 2;
        }
        
        d.put(n, helper(n-1, d) + helper(n-2, d));
        
        return d.get(n);
    }

    // bottom up
    public int climbStairs1(int n) {
        if (n == 1)
            return n;

        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    public int climbStairs3(int n) {
        if (n == 1)
            return n;

        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i < n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n - 1];
    }
}
