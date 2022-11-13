

class DecodeWays{
    public int numDecodings(String s) {
        
        if(s==null || s.length() == 0) return 0;
        
        int n = s.length();
        
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0 : 1;
        
        for(int i=2; i<n+1; i++){
            int first = Integer.valueOf(s.substring(i-1,i));
            int second = Integer.valueOf(s.substring(i-2, i));
            
            if(first >= 1 && first <= 9)
                dp[i] = dp[i-1];
            
            if(second >= 10 && second <= 26)
                dp[i] += dp[i-2];
        }
        
        return dp[n];       
    }

    public int numDecodings1(String s) {
        return dp(s, 0, new HashMap<Integer, Integer>());
    }

    public int dp(String s, int p, HashMap<Integer, Integer> cache) {

        if (cache.containsKey(p))
            return cache.get(p);

        int len = s.length();
        if (p == len) {
            cache.put(p, 1);
            return 1;
        }

        if (s.charAt(p) == '0') {
            cache.put(p, 0);
            return 0;
        }

        int res = dp(s, p + 1, cache);
        if ((p < len - 1) && ((s.charAt(p) == '1') || (s.charAt(p) == '2' && s.charAt(p + 1) < '7'))) {
            res += dp(s, p + 2, cache);
        }

        cache.put(p, res);
        return res;
    }
}