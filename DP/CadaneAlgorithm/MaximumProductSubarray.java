package DP.CadaneAlgorithm;
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int res;
        res = nums[0];
        for(int n:nums){
            res = Math.max(n, res);
        }
        
        int curMax=1, curMin=1;
        
        for(int n:nums){
            if(n==0){
                curMax = 1;
                curMin = 1;
                continue;
            }
            
            int temp = curMax*n;
            curMax = Math.max(curMax*n, curMin*n);
            curMax = Math.max(curMax, n);
            
            curMin = Math.min(temp, curMin*n);
            curMin = Math.min(curMin, n);
            
            res = Math.max(curMax, res);
        }
        
        return res;
    }
}
