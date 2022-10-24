import java.util.*;

class MaximumGap {
    public int MaximumGap(int[] nums) {
        int mi = nums[0];
        int ma = nums[0];
        int len = nums.length;

        for(int n: nums){
            mi = Math.min(n, mi);
            ma = Math.max(n, ma);
        }

        int bucketSize = (int) Math.ceil((double)(ma-mi)/(len-1));

        int[] minBucket = new int[len];
        int[] maxBucket = new int[len];
        Arrays.fill(minBucket, Integer.MIN_VALUE);
        Arrays.fill(maxBucket, Integer.MAX_VALUE);

        for(int x: nums){
            int idx = (int)(x - mi) / bucketSize;

            minBucket[idx] = Math.min(x, minBucket[idx]);
            maxBucket[idx] = Math.max(x, maxBucket[idx]);
        }

        int max_gap = bucketSize;
        int prev = maxBucket[0];
        for(int i=1; i<len; i++){

            if(minBucket[i] == Integer.MIN_VALUE) continue;

            max_gap = Math.max(max_gap, minBucket[i] - prev);
            prev = minBucket[i];
        }

        return max_gap;
        
    }
}
