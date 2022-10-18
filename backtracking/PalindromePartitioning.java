import java.util.*;

public class PalindromePartitioning {
    public List<List<String>> PalindromePartitioning(String s){
        
        List<List<String>> res = new ArrayList<List<String>>();

        backtracking(res, new ArrayList<String>(), s, 0);

        return res;

    }

    public void backtracking(List<List<String>> res, List<String> temp, String s, int index) {

        if (index == s.length()) {
            res.add(new ArrayList<String>(temp));
            return;
        }

        for (int j = index; j < s.length(); j++) {

            if (is_paralin(index, j, s)) {

                temp.add(s.substring(index, j + 1));

                backtracking(res, temp, s, j + 1);

                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean is_paralin(int i, int j, String s) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}