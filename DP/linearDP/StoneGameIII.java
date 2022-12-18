public class StoneGameIII {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        dp[n] = 0;

        for(int i=n-1; i>=0; i--){
            dp[i] = Integer.MIN_VALUE;
            for(int k=0, take=0; k<3 && k+i<n; k++){
                take += stoneValue[i+k];
                dp[i] = Math.max(dp[i], take- dp[i+k+1]);
            }
        }

        if(dp[0] > 0) return "Alice";
        else if(dp[0] < 0) return "Bob";
        else return "Tie";
    }
}
