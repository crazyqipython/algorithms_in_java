public class CountAllValidPickupandDeliveryOptions {
    private int mod = (int )Math.pow(10, 9) + 7;
    public int countOrders(int n) {
        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<n+1; i++){
            int spaceCount = (i-1) * 2 + 1;
            int val = (spaceCount*(spaceCount+1)) / 2;
            dp[i] = (dp[i-1] * val) % mod;
        }
        return (int) dp[n];
    }
}
