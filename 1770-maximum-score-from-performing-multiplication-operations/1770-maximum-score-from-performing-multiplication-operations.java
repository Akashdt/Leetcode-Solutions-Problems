class Solution {
     int res(int i,int[] nums, int[] multipliers, int s,int dp[][])
    {
        if(i==multipliers.length)
            return 0;
        
        if(dp[i][s]!=0)
            return dp[i][s];
        
        int e=nums.length-(i-s)-1;
        
        int op1=multipliers[i]*nums[s]+res(i+1,nums,multipliers,s+1,dp);
        int op2=multipliers[i]*nums[e]+res(i+1,nums,multipliers,s,dp);
        
        return dp[i][s]=Math.max(op1,op2);
    }
    public int maximumScore(int[] nums, int[] multipliers) 
    {
        int m=multipliers.length;
        int dp[][] = new int[m][m];
        
        return res(0,nums,multipliers,0,dp);
    }
}