import java.util.*;

public class NQueens{
    public int NQueens(int n){
        List<List<String>> res = new ArrayList<List<String>>();
        HashSet<Integer> visited = new HashSet<Integer>();
        HashSet<Integer> posDiag = new HashSet<Integer>();
        HashSet<Integer> negDiag = new HashSet<Integer>();

        backtracking(res, new ArrayList<String>(), n, 0, visited, posDiag, negDiag);

        return res.size();
    }

    public void backtracking(List<List<String>> res, List<String> temp, int n, int row, HashSet<Integer> visited, HashSet<Integer> posDiag, HashSet<Integer> negDiag){
        
        if(temp.size() == n){

            res.add(new ArrayList<String>(temp));
            return;
        }

        for(int i=0; i<n; i++){

            if(visited.contains(i) || posDiag.contains(i+row)||negDiag.contains(i-row)) continue;

            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[i] = 'Q';
            String rowString = Arrays.toString(charArray);
            temp.add(rowString);
            visited.add(i);
            posDiag.add(i+row);
            negDiag.add(i-row);

            backtracking(res, temp, n, row+1, visited, posDiag, negDiag);

            temp.remove(temp.size() - 1);
            visited.remove(i);
            posDiag.remove(i + row);
            negDiag.remove(i - row);
        }
    }
}