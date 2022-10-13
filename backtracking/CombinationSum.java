import java.util.*;

public CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> temp, int[] nums, int remain, int index){
        if ( remain < 0) return;

        if (remain == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index; i < nums.length; i++){
            temp.add(nums[i]);
            backtracking(res, temp, nums, remain - nums[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}