import java.util.*;

public class Permutations {
    public List<List<Integer>> Permutations(int[] nums){
        List<List<Integer>> res = new ArrayList<>();

        backtracking(res, nums, new ArrayList<Integer>(), nums.length);
        return res;
    }

    public void backtracking(List<List<Integer>> res, int[] nums, List<Integer> temp, int n){

        if (n == temp.size()){
            res.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){

            if(temp.contains(nums[i])) continue;

            temp.add(nums[i]);

            backtracking(res, nums, temp, n);

            temp.remove(temp.size() - 1);
        }
    }
}
