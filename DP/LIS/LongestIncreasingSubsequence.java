package DP.LIS;

import java.util.*;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
        }
        
        int res = 0;
        for(int k=0; k<n; k++){
            res = Math.max(res, dp[k]);
        }
        
        return res;
    }
}
