
class MinimumSizeSubarraySum{
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int l = 0, r = 0, sum = 0;
        Integer res = Integer.MAX_VALUE;

        while (r < nums.length) {
            sum += nums[r];

            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;

        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}