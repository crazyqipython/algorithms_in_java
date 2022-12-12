package DP.linearDP;

public class LongestArithmeticSubsequenceofGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        HashMap<Integer, Integer> dp = new HashMap<>();

        int longest = 1;

        for (int a : arr) {
            dp.put(a, 1 + dp.getOrDefault(a - difference, 0));
            longest = Math.max(dp.get(a), longest);
        }
        return longest;
    }
}
