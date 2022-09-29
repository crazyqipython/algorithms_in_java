import java.util.HashMap;
import java.util.Hashtable;
import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int i=0; i < nums.length; i++) {
            int number1 = target - nums[i];
            if (h.containsKey(number1)) {
                result[0] = i;
                result[i] = h.get(number1);
                return result;
            } else {
                h.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String args[]){
        int[] res = twoSum(new int[]{12, 17, 21, 25}, 29);
        System.out.println(Arrays.toString(res));
    }
}
