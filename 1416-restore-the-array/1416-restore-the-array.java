class Solution {
        
    public int numberOfArrays(String s, int k) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return dfs(s,k,0,dp,n);
    }
    public int dfs(String s,int k,int i,int[] dp,int n){
      if(i==n)return 1;
      if(s.charAt(i)=='0')return 0;
      if(dp[i]!=-1) return dp[i];
      
      int ans=0;
      long num=0;
      for(int j=i;j<n;j++){
        num=num*10+s.charAt(j)-'0';
        if(num>k)break;
        
        ans+=dfs(s,k,j+1,dp,n);
        ans%=1000000007;
      }
      return dp[i]=ans;
    }
}