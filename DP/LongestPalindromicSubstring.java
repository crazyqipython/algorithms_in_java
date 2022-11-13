public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        
        for(int i=0; i<len; i++){
            dp[i][i] = true;
            
        }
        String res = s.substring(0, 1);
        int start = 0;
        int end = 0;
        
        for(int i=len-1; i>=0; i--){
            for(int j=i+1; j<len; j++){
                
                if((s.charAt(i) == s.charAt(j)) && (j-i==1 || dp[i+1][j-1] == true)){
                    dp[i][j] = true;
                }
                
                if(dp[i][j]){
                    if(j-i > end - start){
                        start = i;
                        end = j;
                    }
                }
            }
        }
        
        return s.substring(start, end+1);
    }
}
