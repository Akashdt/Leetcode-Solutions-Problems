class Solution 
{
    private final Random r = new Random();
        
    public int findKthLargest(int[] nums, int k) 
    {
        int index = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) 
        {
            int pivotIdx = partition(nums, lo, hi);
            if (pivotIdx == index) {
                break;
            } else if (pivotIdx < index)
            {
                lo = pivotIdx + 1;
            } else 
            {
                hi = pivotIdx - 1;
            }
        }
        return nums[index];
    }
    
    private int partition(int[] nums, int lo, int hi) 
    {
        swap(nums, hi, lo + r.nextInt(hi - lo));
        int pivot = nums[hi];
        int j = lo;
        for (int i = lo; i < hi; i++) 
        {
            if (nums[i] < pivot) {
                swap(nums, i, j++);
            }
        }
        swap(nums, hi, j);
        return j;
    }
    
    private void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}