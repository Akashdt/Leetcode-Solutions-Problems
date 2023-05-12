class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
    long[] dp = new long[n + 1]; // dp[i]: max points from question i
    
    // initialize the last two elements of the dp table
    dp[n] = 0;
    dp[n - 1] = questions[n - 1][0];
    
    // fill the dp table from right to left
    for (int i = n - 2; i >= 0; i--) {
        // calculate the maximum points from skipping and solving
        long skip = dp[i + 1];
        long solve = questions[i][0];
        if (i + questions[i][1] < n) {
            solve += dp[i + questions[i][1] + 1];
        }
        dp[i] = Math.max(skip, solve);
    }
    
    return dp[0];
    }
}