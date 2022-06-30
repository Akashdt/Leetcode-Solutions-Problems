class Solution {
    public int minMoves2(int[] nums)
    {
        Arrays.sort(nums);
           int c=0;
            
            int mid = nums[nums.length/2];
            
	for (int i:nums)
        {
                int s=Math.abs(mid-i);
                c=c+s;
        }
	return c; 
    }
}
