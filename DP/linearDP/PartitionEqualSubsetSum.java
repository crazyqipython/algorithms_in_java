package DP.linearDP;
import java.util.*;
//0/1 knapsack 
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        
        int sum=0;
        for(int n: nums) sum = sum + n;
        
        if(sum % 2 == 1) return false;  
        
        int target = sum / 2;
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(0);
        
        for(int n: nums){
            
            HashSet<Integer> newSet = new HashSet<Integer>();
            
            for(int e: set){
                newSet.add(e);
                newSet.add(e+n);
            }
            
            set = newSet;
            if(set.contains(target)) return true;
        }
        
        return set.contains(target) ? true : false;
    }
}
