package DP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RegularExpressionMatching{

    public static HashMap<ArrayList<Integer>, Boolean> cache = new HashMap<ArrayList<Integer>,Boolean>();

    public Boolean  RegularExpressionMatching(String s, String p){
        
        return dfs(s, p, 0, 0);
    }

    public static Boolean dfs(String s, String p, int i, int j) {

        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(i);
        arr.add(j);
        if(cache.containsKey(arr)){
            return cache.get(arr);
        }

        if (i >= s.length() && j >= p.length())
            return true;

        if (j >= p.length())
            return false;

        Boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            cache.put(arr, dfs(s, p, i, j + 2) || (match && dfs(s, p, i + 1, j)));
            return cache.get(arr);
        }

        if (match){
            cache.put(arr, dfs(s, p, i + 1, j + 1));
            return cache.get(arr);
        }

        return false;

    }
}