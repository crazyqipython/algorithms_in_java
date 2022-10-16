import java.util.*;

public class SubsetsII {
    public List<List<Integer>> SubsetsII(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            backtracking(res, new ArrayList<Integer>(), i, nums, 0);
        }

        List<Integer> t = new ArrayList<Integer>();
        for(int n: nums){
            t.add(n);
        }
        res.add(t);
        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> temp, int l, int[] nums, int index){

        if (temp.size() == l){
            res.add(new ArrayList<Integer>(temp));
        }

        for(int i=index; i<nums.length; i++){

            if(i>index && nums[i] == nums[i-1]) continue;

            temp.add(nums[i]);

            backtracking(res, temp, l, nums, index+1);

            temp.remove(temp.size() - 1);
        }
    }
}
