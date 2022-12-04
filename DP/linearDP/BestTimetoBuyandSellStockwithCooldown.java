package DP.linearDP;

public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length <= 1) return 0;
        
        int n = prices.length;
        
        int[] buy = new int[n+1];
        int[] sell = new int[n+1];
        
        buy[1] = -prices[0];
        
        for(int i=2; i<n+1; i++){
            int pri = prices[i-1];
            buy[i] = Math.max(buy[i-1], sell[i-2] - pri);
            
            sell[i] = Math.max(sell[i-1], buy[i-1] + pri);
        }
        
        return sell[n];
    }
}
