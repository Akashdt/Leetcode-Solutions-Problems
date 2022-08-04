class Solution {
    public int minSubArrayLen(int target, int[] nums) {
         int ans=nums.length+1;
        int left=0;
        int right=0;
        int sum=0;
        
        while(right<nums.length)
        {
            sum+=nums[right];
           
                while(sum>=target)
                {
                         ans=Math.min(ans,right-left+1);
                    sum-=nums[left];
                    left++;
                }
               right++;
        } 
            if(ans==nums.length+1)
            {
                    return 0;
            }
        
        
        return  ans;
    }
}