class Solution 
{
    long m=(long)Math.pow(10,9)+7;
        
    public int countVowelPermutation(int n) 
    {
        long[][] dp=new long[n][5];
        for(int i=0;i<5;i++)
        {
            dp[0][i]=1;
        }
            
        for(int i=1;i<n;i++)
        {
            dp[i][0]=(dp[i-1][1]+dp[i-1][2]+dp[i-1][4])%m;
            dp[i][1]=(dp[i-1][0]+dp[i-1][2])%m;
            dp[i][2]=(dp[i-1][1]+dp[i-1][3])%m;
            dp[i][3]=dp[i-1][2];
            dp[i][4]=(dp[i-1][2]+dp[i-1][3])%m;
        }
        return (int)((dp[n-1][0]+dp[n-1][1]+dp[n-1][2]+dp[n-1][3]+dp[n-1][4])%m);
    }
}