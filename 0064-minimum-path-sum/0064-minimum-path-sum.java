class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return helper(grid, dp, 0, 0);
    }

    public int helper(int[][] grid, int dp[][], int i, int j){
        if(i >= grid.length || j >= grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int a = helper(grid, dp, i+1, j);
        int b = helper(grid, dp, i, j+1);

        int min = Math.min(a, b);
        if(min == Integer.MAX_VALUE) min = 0;
        dp[i][j] = grid[i][j] + min;
        return dp[i][j];
    }
}
