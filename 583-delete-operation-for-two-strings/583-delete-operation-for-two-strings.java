class Solution {
    public int minDistance(String s, String t)
    {
           int m = s.length(), n = t.length();
            
        int[][] dp = new int[m + 1][n + 1];
            
        for(int[] row : dp) Arrays.fill(row, -1);
        
        for(int i = 0; i <= m; i++)
            dp[i][0] = i;
        
        for(int j = 0; j <= n; j++)
            dp[0][j] = j;
            
        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                
                    if(s.charAt(i - 1) == t.charAt(j - 1))
                            
                    dp[i][j] = dp[i - 1][j - 1];
                else
                {
                    int deleteInS = dp[i - 1][j];
                    int deleteInT = dp[i][j - 1];
                    dp[i][j] = Math.min(deleteInS, deleteInT) + 1;
                }
            }
        }
        
        return dp[m][n];             
  

    }
}