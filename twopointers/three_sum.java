package TwoPointers;
import java.util.*;
public class three_sum {
    public List<List<Integer>> three_sum(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                    j++;
                    k--;
                    while (j < nums.length && nums[j - 1] == nums[j])
                        j++;
                    while (k > 0 && nums[k] == nums[k + 1])
                        k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}