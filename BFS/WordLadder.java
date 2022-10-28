import java.util.*;

public class WordLadder{

    public int WordLadder(String beginWord, String endWord, List<String> wordList){

        Set<String> set = new HashSet<String>(wordList);
        int res = 0;

        HashSet<String> visited = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        visited.add(beginWord);

        res = 1;
        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();

                if (word.equals(endWord))
                    return res;

                for (int j = 0; j < word.length(); j++) {
                    char[] arr = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old_ch = arr[j];
                        arr[j] = c;

                        String target = new String(arr);

                        if (set.contains(target) && (!visited.contains(target))) {
                            visited.add(target);
                            q.add(target);
                        }

                        arr[j] = old_ch;
                    }
                }
            }

            res++;
        }

        return 0;
    }

}