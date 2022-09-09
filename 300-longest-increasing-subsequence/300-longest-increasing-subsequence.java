class Solution {
    public int lengthOfLIS(int[] nums)
    {
         int[] arr = new int[nums.length];
            
        Arrays.fill(arr, 1);
            
        int max = 1;
            
        for(int i = nums.length-1; i >= 0; i--)
        {
            for(int j = i+1; j < nums.length; j++)
            {
                if(nums[i] < nums[j])
                {
                    arr[i] = Math.max(arr[i], arr[j]+1);
                }
            }
                
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}