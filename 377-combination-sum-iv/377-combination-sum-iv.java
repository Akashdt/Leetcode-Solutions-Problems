class Solution {
    public int combinationSum4(int[] nums, int target) {
         int[] arr=new int[target+1];
        arr[0]=0;
        for(int i=0;i<target+1;i++)
        {
            for(int j=0;j<nums.length;j++)
            {

                if(i-nums[j]>0)
                {
                    arr[i]=arr[i]+arr[i-nums[j]];
                }
                else if(nums[j]-i==0)
                {
                    arr[i]=arr[i]+1;
                }
                
            }
            
        }
        
        return arr[target];
    }
}