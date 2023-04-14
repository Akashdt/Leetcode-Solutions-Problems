class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String reverse = (new StringBuffer(s)).reverse().toString();
        int[][] dp = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                int match = 0;
                int notMatch = 0;
                if(s.charAt(i-1) == reverse.charAt(j-1)) {
                    match = 1 + dp[i-1][j-1];
                } else {
                    notMatch = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                dp[i][j] = Math.max(match, notMatch);
            }
        }
        return dp[n][n];
    }
}