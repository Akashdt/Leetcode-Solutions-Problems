class Solution {
    public int numTilings(int n) {
         long[] dp = new long [n+1];
        if(n == 0 )return 0;
        dp[0] = 1; 
        if(n == 1 )return 1;
        dp[1] = 1; 
        if(n == 2 )return 2;
        dp[2] =2;
        long mod = 1000000007;
        for(int i =3; i<=n; i++) {
            dp[i] = (2*dp[i-1] + dp[i-3]) % mod;
        }
        return (int) dp[n]; 
    }
}