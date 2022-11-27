package DP.linearDP;
import java.util.*;

public class HouseRobber {
    public int rob(int[] nums) {

        int length = nums.length - 1;
        return help(nums, length, new HashMap<Integer, Integer>());
    }

    public int help(int[] nums, int n, HashMap<Integer, Integer> cache) {

        if (cache.containsKey(n))
            return cache.get(n);

        if (n == 0)
            return nums[n];

        if (n == 1)
            return nums[0] > nums[1] ? nums[0] : nums[1];

        cache.put(n, Math.max(help(nums, n - 1, cache), help(nums, n - 2, cache) + nums[n]));
        return cache.get(n);
    }

    public int rob3(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];

    }

    public int rob1(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];

    }
}
