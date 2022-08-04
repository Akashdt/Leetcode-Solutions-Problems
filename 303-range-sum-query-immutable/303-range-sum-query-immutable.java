class NumArray {
    private int[] prefixSumArray;

    public NumArray(int[] nums)
    {
        prefixSumArray=new int [nums.length];
            
        prefixSumArray[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            prefixSumArray[i]=prefixSumArray[i-1]+nums[i];
        }
    }
    
    public int sumRange(int left, int right)
    {
        if(left==0) 
        {
                return prefixSumArray[right];
        }
        return prefixSumArray[right]-prefixSumArray[left-1];
    }
}
