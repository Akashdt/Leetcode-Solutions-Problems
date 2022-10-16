class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
         
        if(jobDifficulty.length<d) return -1;
        int[][]dp = new int[d+1][jobDifficulty.length];

        for(int []arr :dp) Arrays.fill(arr ,-1);

        return dfs(dp, jobDifficulty , d , 0);

    }
    private int dfs(int[][]dp , int[]jobDifficulty  , int days , int idx){

        if(days==1){
            int max = Integer.MIN_VALUE;
            for(int i=idx ;i<jobDifficulty.length ;i++){
                max = Math.max(max , jobDifficulty[i]);
            }
            return max;
        }
        
        if(dp[days][idx]!=-1) return dp[days][idx];
        
        int leftMax =0;
        int res = Integer.MAX_VALUE;
        
        for(int i=idx ; i<jobDifficulty.length-days+1 ;i++)
        {   
            leftMax = Math.max(leftMax , jobDifficulty[i]);
            int rightMax = dfs(dp , jobDifficulty , days-1 , i+1);
            res = Math.min(res , leftMax+rightMax);
        }
        
        return dp[days][idx] = res;
    }
}