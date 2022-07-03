class Solution {
    public int wiggleMaxLength(int[] nums)
    {
         int n = nums.length,m = 1,h = 1;
        for(int i = 0; i<n-1; i++)
        {
            if(nums[i]>nums[i+1])
            {
                m=h+1;
            }
            else if(nums[i]<nums[i+1])
            {
                h= m+1;
            }
        }
        return Math.max(h,m);
    }
}