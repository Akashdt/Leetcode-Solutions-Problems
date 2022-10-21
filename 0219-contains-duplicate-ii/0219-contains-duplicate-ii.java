class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) 
    {
        HashMap hm = new HashMap();
                for(int i=0; i<nums.length; i++)
                {
                if(!hm.containsKey(nums[i]))
                {
                        hm.put(nums[i], i);
                }

        else
        {
            int a = (int)hm.get(nums[i]);
                
            if(Math.abs(a-i)<=k)
               
                    return true;
           
            else
                hm.put(nums[i], i);
        }
    }
    
    return false;
}
    }
