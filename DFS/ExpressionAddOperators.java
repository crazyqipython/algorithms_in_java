package DepthFirstSearch;
import java.util.*;

public class ExpressionAddOperators {
    public List<String> ExpressionAddOperators(String num, int target){
        List<String> res = new ArrayList<String>();

        if(num == null || num.length() == 0) return res;

        dfs(res, "", num, target, 0, 0, 0);

        return res;
    }

    public void dfs(List<String> res, String temp, String num, int target, int pos, long eval, long multed){
        if(pos == num.length()){
            if(eval == target){
                res.add(temp);
            }
            return;
        }

        for(int i=pos; i<num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;

            long cur = Long.parseLong(num.substring(pos, i+1));

            if(pos == 0){
                dfs(res, temp+cur, num, target, i+1, cur, cur);
            }else{
                dfs(res, temp + "+" + cur, num, target, i+1, eval + cur, cur);
                dfs(res, temp + "-" + cur, num, target, i+1, eval - cur, -cur);
                dfs(res, temp + "*" + cur, num, target, i+1, eval - cur + multed*cur, multed*cur);
            }
        }
    }
}
