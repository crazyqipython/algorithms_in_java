import java.util.*;

public class FillingBookcaseShelves{
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        
        for(int i=1; i<n+1; i++){
            int curWidth = books[i-1][0];
            int curHeight = books[i-1][1];
            
            dp[i] = dp[i-1] + curHeight;
            for(int j = i-1; j>0; j--){
                curWidth += books[j-1][0];
                
                if(curWidth > shelfWidth) break;
                
                curHeight = Math.max(curHeight, books[j-1][1]);
                dp[i] = Math.min(dp[i], dp[j-1] + curHeight);
            }
            
        }
        
        return dp[n];
    }
}