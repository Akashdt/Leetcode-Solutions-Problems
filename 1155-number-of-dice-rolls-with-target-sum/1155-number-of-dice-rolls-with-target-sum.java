class Solution {
    public int numRollsToTarget(int n, int k, int target) {
           int MOD = 1000000007;
            long [][]memo = new long[n+1][target+1];
            for (int i=1;i<=n;i++){
                for (int j=i;j<=target;j++){
                    if (j>i*k)continue;
                    else if (i==j || i==1)memo[i][j]=1;
                    else {
                        memo[i][j] = memo[i-1][j-1];
                        for (int p=Math.max(1, j-k);p<j-1;p++){
                            memo[i][j]=(memo[i][j]+memo[i-1][p])%MOD;
                        }
                    }
                }
            }
                
          return (int)(memo[n][target]); 
    }
}