class Solution {
    public boolean checkPossibility(int[] nums)
    {
          int count = 0;
        for(int i = 0; i + 1 < nums.length; i++)
        {
            if(nums[i] > nums[i + 1])
            {
                    count++;//if the element is greater then next
            
                
                if(count> 1) 
                {
                        return false; //since we can make only one modification
                }  
                    
                else if(i > 0 && nums[i + 1] < nums[i - 1])
                {
                    nums[i + 1] = nums[i];//swap
                }
            }
          }
        
        return true;
    }
   }
