import java.util.*;

public class KnightDialer {
    class Solution {
        public static final int max = 1000000007;
        private static final int[][] dirs = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 },
                { -1, -2 }, { -2, -1 } };
        Map<String, Long> pathCount = new HashMap<String, Long>();

        public int knightDialer(int N) {
            long res = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    res = (res + helper(i, j, N)) % max;
                }
            }
            return (int) res;
        }

        public long helper(int i, int j, int n) {

            if (i < 0 || i >= 4 || j < 0 || j >= 3 || (i == 3 && j != 1))
                return 0;
            if (n == 1)
                return 1;
            String key = i + "_" + j + "_" + n;
            if (pathCount.containsKey(key))
                return pathCount.get(key);
            long ans = 0;
            for (int k = 0; k < dirs.length; k++) {
                ans += helper(i + dirs[k][0], j + dirs[k][1], n - 1) % max;
            }
            pathCount.put(key, ans);
            return ans;
        }
    }
}
