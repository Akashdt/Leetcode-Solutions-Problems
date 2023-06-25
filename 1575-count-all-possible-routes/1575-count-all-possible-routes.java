class Solution {
  public int countRoutes(int[] locations, int start, int finish, int fuel) 
  {
    if(Math.abs(locations[start] - locations[finish]) > fuel) 
            
            return 0;
    int a = locations[start], b = locations[finish], n = locations.length;
          
    Arrays.sort(locations);
          
    for(int i = 0; i != n; ++i)
    {
      if(locations[i] == a)
              a = i;
            
      if(locations[i] == b)
              b = i;
    }

    long dp[][] = new long[fuel+1][n];;
    dp[fuel][a] = 1;

    for(int i = fuel; i != 0; --i)
      for(int j = 0; j != n; ++j)
        if(dp[i][j] != 0){
          for(int k = j + 1; k != n; ++k){
            int row = i - locations[k] + locations[j];
            if(row < 0) break;
            dp[row][k] += dp[i][j];
          }
          for(int k = j - 1; k >= 0; --k){
            int row = i + locations[k] - locations[j];
            if(row < 0) break;
            dp[row][k] = (dp[row][k] + dp[i][j]) % 1000000007;
          } 
        }

    int ans = 0;
    for(int i = 0; i <= fuel; ++i) ans = (int)((ans + dp[i][b]) % 1000000007);

    return ans;    
  }
}