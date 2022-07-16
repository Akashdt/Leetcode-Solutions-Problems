class Solution {
    int mod = 1000000007;
    int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[maxMove+1][m][n];
        
        for(int[][] l : dp){
            for(int[] k: l){
                Arrays.fill(k, -1);
            }
        }
        
        int ans = recursion(m, n, maxMove, startRow, startColumn, dp);
        return ans;
    }
    
    private int recursion(int m, int n, int maxMove, int startRow, 
                          int startCol, int[][][] dp){
        if(startRow < 0 || startRow == m || startCol < 0 || startCol == n) return 1;
        if(maxMove == 0) return 0;
        if(dp[maxMove][startRow][startCol] != -1) return dp[maxMove][startRow][startCol];
        long paths = 0;
        
        for(int i=0; i<directions.length ; i++){
            int[] current = directions[i];
            paths += recursion(m, n, maxMove-1, startRow+current[0], 
                               startCol+current[1], dp);
            
        }
        dp[maxMove][startRow][startCol] = (int)(paths%mod);
        return dp[maxMove][startRow][startCol];
}
}