class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j == 0 ){
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                }else if(j == n - 1){
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                    dp[i][j] = Math.min(dp[i - 1][j + 1], dp[i][j]);
                }

                dp[i][j] += matrix[i][j];
            }
        }

        int res = Integer.MAX_VALUE;
        for(int num : dp[n- 1]){
            res = Math.min(res, num);
        }

        return res;
    }
}