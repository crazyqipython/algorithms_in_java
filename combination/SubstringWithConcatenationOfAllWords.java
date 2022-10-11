package Combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public ArrayList<Integer> findSubstring(String s, String[] words){
        if(s==null || words==null ){
            ArrayList<Integer> a = new ArrayList<Integer>();
            return a;
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        for(String w: words){
            int c = count.containsKey(w) ? count.get(w): 0;
            count.put(w, c+1);
        }

        int wordLength = words[0].length();

        for(int left=0; left < s.length() - wordLength * words.length + 1; left++){
            HashMap<String, Integer> wordSeen = new HashMap<String,Integer>();

            if(left==12){
                System.out.println(left);
            }

            for(int right=0; right < words.length; right++){
                int wordIndex = left + right * wordLength;
                if(wordIndex >= s.length()) break;
                String tempWord = s.substring(wordIndex, wordIndex + wordLength); 

                if(!count.containsKey(tempWord)) break;

                int cnt = wordSeen.containsKey(tempWord)? wordSeen.get(tempWord): 0;
                wordSeen.put(tempWord, cnt+1);

                if(wordSeen.get(tempWord) > count.get(tempWord)) break;
            }

            if(count.equals(wordSeen)) res.add(left);
        }

        return res;
    }

    public static void main(String [] strings) {
        String s = "ababababab";
        String[] words = new String[] {"ababa","babab"};
        SubstringWithConcatenationOfAllWords obj = new SubstringWithConcatenationOfAllWords();
        ArrayList<Integer> res = obj.findSubstring(s, words);
        System.out.println(res.toString());
    };
}
