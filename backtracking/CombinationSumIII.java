import java.util.*;

public class CombinationSumIII {

    public List<List<Integer>> CombinationSumIII(int k, int n) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        backtracking(res, new ArrayList<Integer>(), k, 1, n);

        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> temp, int k, int index, int remain){

        if(temp.size() > k || remain < 0) return;

        if(temp.size() == k && remain == 0){
            res.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int i = index; i < 10; i++){

            if(temp.contains(i)) continue;

            temp.add(i);
            backtracking(res, temp, k, i+1, remain - i);
            temp.remove(temp.size() - 1);

        }


    }

}
