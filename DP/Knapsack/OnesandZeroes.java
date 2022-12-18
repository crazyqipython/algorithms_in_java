import java.util.*;
class OnesandZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            Arrays.fill(dp[i], 0);
        }

        for(String s: strs){
            int[] nums = calculate(s);

            for(int j=m; j>=0; j--){
                for(int k=n; k>=0; k--){
                    if(j>=nums[0] && k>=nums[1]){
                        dp[j][k] = Math.max(dp[j][k], dp[j-nums[0]][k-nums[1]]);
                    }else{
                        dp[j][k] = dp[j][k];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public int[] calculate(String s){
        int[] res = new int[2];
        Arrays.fill(res, 0);

        for(char ch: s.toCharArray()){
            if(ch=='0'){
                res[0]++;
            }else if(ch=='1'){
                res[1]++;
            }
        }
        return res;
    }
}