import java.util.*;
/** 
        Let res[i] represents the number of unique numbers among i-digit numbers.
For example:

res[0] = 1, since there is only 0.

res[1] = 9, because all one-digit numbers are unique : 1,2,3,4,5,6,7,8,9.

res[2] = 81,
Because among all two-digit numbers (10 - 99), the number with unique digits = 9 * 9.
The first digit is chosen from (1,2,3,4,5,6,7,8,9), so there are 9 choices,
The second digit is chosen from (0,1,2,3,4,5,6,7,8,9) except the one has been chosen as the first digit, so there are 9 choices.

res[3] = 9 * 9 * 8 = 648.

res[4] = 9 * 9 * 8 * 7.

And so on so forth.
The result is the sum from res[0] to res[n].

We can notice that:
res[0] = 1,
res[1] = 9,
res[2] = 9 * 9 = 9 * res[1],
res[3] = 9 * 9 * 8 = 8 * res[2],
res[4] = 9 * 9 * 8 * 7 = 7 * res[3].

Apparently, we can compute the latter one using DP.
***/

class CountNumberswithUniqueDigits{
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int sum = 1;
        int k = 9;

        for (int i = 1; i < n + 1; i++) {
            if (i == 1)
                dp[i] = dp[i - 1] * 9;

            else
                dp[i] = dp[i - 1] * k--;

            sum += dp[i];
        }

        return sum;
    }
}