class Solution {
    public int[] productExceptSelf(int[] nums)
    {
         int n = nums.length;
            
        int[] res = new int[n];
            
        res[n-1]=1;
            
        for (int i = n - 2; i >= 0; i--) 
        {
                res[i] =res[i+1]*nums[i+1];;
        }
            int p=1;
        for (int i = 1; i < n; i++) 
        {
            
                p=p*nums[i-1];
                res[i]=res[i]*p;
        }
       
        return res;
    }
}