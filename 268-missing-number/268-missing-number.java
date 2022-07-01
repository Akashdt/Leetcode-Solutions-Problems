class Solution {
    public int missingNumber(int[] nums) 
    {
         Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (true) 
        {
            mid = (l + r) / 2;
            if (l > r)
                return l;
                
            if (nums[mid] > mid)
                r = mid - 1;
            else
                l = mid + 1;
    }
}
}