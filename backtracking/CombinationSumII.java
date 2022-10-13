import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> CombinationSumII(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList();

        Arrays.sort(candidates);
        backtracking(res, candidates, new ArrayList<Integer>(), target, 0);

        return res;
    }

    public void backtracking(List<List<Integer>> res, int[] candidates, List<Integer> temp, int remain, int index){
        if(remain < 0) return;

        if(remain == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int i=index; i<candidates.length; i++){
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            
            temp.add(candidates[i]);
            backtracking(res, candidates, temp, remain - candidates[i], i+1);
            temp.remove(temp.size() - 1);
        }
    }
}
