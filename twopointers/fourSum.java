package TwoPointers;

import java.util.*;

public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                long t = (long) target - nums[i] - nums[j];
                int l = j + 1;
                int r = length - 1;
                while (l < r) {

                    if (t == nums[l] + nums[r]) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));

                        r--;
                        l++;
                        while (l < r && nums[r] == nums[r + 1])
                            r--;
                        while (l < r && nums[l] == nums[l - 1])
                            l++;
                    } else if (nums[l] + nums[r] > t) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }

        return res;
    }
}