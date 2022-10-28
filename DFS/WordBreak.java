package DepthFirstSearch;

import java.util.*;
public class WordBreak {
    Boolean mem[];

    public boolean wordBreak(String s, List<String> wordDict) {

        mem = new Boolean[s.length()];
        return help(0, s, new HashSet<String>(wordDict));
    }

    public boolean help(int p, String s, HashSet<String> wordDict) {

        int n = s.length();

        if (p == n)
            return true;

        if (mem[p] != null)
            return mem[p];

        for (int i = p + 1; i <= n; i++) {
            if (wordDict.contains(s.substring(p, i)) && help(i, s, wordDict)) {
                mem[p] = true;
                return true;
            }
        }
        mem[p] = false;
        return false;

    }
}
