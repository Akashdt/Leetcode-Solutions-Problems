class Solution {
    public int largestPerimeter(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
            
        for(int i=len-1;i>1;i--)
        
        {
            if(nums[i]<nums[i-1] + nums[i-2])
            {
                return nums[i] + nums[i-1] + nums[i-2];
            }
        }
        
        return 0;
    }
}