import java.util.*;
// 避免重复 避免多次使用
public class PermutationsII {

    public List<List<Integer>> PermutationsII(int[] nums){

        List<List<Integer>> list = new ArrayList<List<Integer>>();

        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);
        backtracking(list, new ArrayList<Integer>(), nums, nums.length, used);

        return list;
    }

    public void backtracking(List<List<Integer>> list, List<Integer> temp, int[] nums, int n, boolean[] used) {

        if (temp.size() == n) {
            if (list.contains(temp)) return;
            else{
                list.add(new ArrayList<Integer>(temp));
                return;
            } 
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;

            // if(i>0 && nums[i] == nums[i-1]) continue;

            used[i] = true;
            temp.add(nums[i]);
            backtracking(list, temp, nums, n, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}