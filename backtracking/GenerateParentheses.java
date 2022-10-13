import java.util.*;

public class GenerateParentheses() {
    public List<String> generateParentheses(int n){
        List<String> res = new ArrayList<String>();
        backtracking(res, "", 0, 0, n);
        return res;
    }
    public void backtracking(List<String> l, String s, int open, int close, int n){
        if (s.length() == 2*n) {
            l.add(s);
            return;
        }

        if (open < n) backtracking(l, s+'(', open+1, close, n);
        if (close < open) backtracking(l, s+')', open, close+1, n);
    }
}