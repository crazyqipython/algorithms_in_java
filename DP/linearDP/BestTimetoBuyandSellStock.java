package DP.linearDP;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int res = 0;
        int sofaMin = prices[0];
        for(int i=0; i<prices.length; i++){
            if(prices[i] > sofaMin)
                res = Math.max(res, prices[i] - sofaMin);
            else
                sofaMin = prices[i];
        }
        return res;
    }
}
