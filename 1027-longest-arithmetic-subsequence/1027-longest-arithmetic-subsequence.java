class Solution {
    public int longestArithSeqLength(int[] nums) {
        int dp[][] = new int[nums.length][1010];
        int ans =0 ;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                int diff = nums[i]-nums[j];
                dp[i][diff+501] =  1+dp[j][diff+501];
                ans = Math.max(ans,dp[i][diff+501]);
            }
        }
        return ans+1;
    }
}