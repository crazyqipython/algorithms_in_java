package HashTable;
import java.util.*;

public class LongestSubstringWithoutRepeatString {
    
    public static int LongestSubstringWith(String s){
        if (s.length() == 0) return 0;
        int res = -1;
        int j = 0;
        HashMap<Character, Integer> CharDict = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (CharDict.containsKey(s.charAt(i))) {
                j = Math.max(j, CharDict.get(s.charAt(i)) + 1);
            }
            CharDict.put(s.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(LongestSubstringWith("tmmzuxt"));
    }
}
