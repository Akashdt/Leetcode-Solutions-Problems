class Solution {
    public int minSubArrayLen(int target, int[] nums)
    {
         int ans=Integer.MAX_VALUE;
        int left=0;
        int sum=0;int i;
       for( i=0;i<nums.length;i++)
       {
            sum+=nums[i];
               
       
            while(sum>=target)
                {
                     ans=Math.min(ans,i+1-left);
                    sum-=nums[left];
                    left++;
                }     
       }
        
          return ans == Integer.MAX_VALUE?0:ans;
    }
    }
