public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int max_days = days[n - 1];
        int[] dp = new int[max_days + 1];
        dp[0] = 0;

        boolean[] isTravelday = new boolean[max_days + 1];
        for (int day : days) {
            isTravelday[day] = true;
        }

        for (int i = 1; i <= max_days; i++) {
            if (!isTravelday[i]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + costs[0];
                dp[i] = Math.min(dp[i], costs[1] + dp[Math.max(i - 7, 0)]);
                dp[i] = Math.min(dp[i], costs[2] + dp[Math.max(i - 30, 0)]);
            }
        }

        return dp[max_days];
    }
}