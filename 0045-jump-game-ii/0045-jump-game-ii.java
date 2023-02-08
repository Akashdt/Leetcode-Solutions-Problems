class Solution {
    public int jump(int[] nums) {
       int jumpIndex = 0;
        int jumps = 0;
        int maxJumpIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxJumpIndex = Math.max(maxJumpIndex, nums[i] + i);
            if (i == jumpIndex) {
                jumpIndex = maxJumpIndex;
                jumps++;
            } 
        }
        return jumps;  
    }
}