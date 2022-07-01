class Solution {
    public List<Integer> findDuplicates(int[] nums) {
            HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> l= new ArrayList<Integer>();
            
            for(int i=0;i<nums.length;i++)
            {
                    if(map.containsKey(nums[i]))
                       {
                                l.add(nums[i]);
                            
                       }
                    else
                    {
                            map.put(nums[i],0);
                    }
            }
                       return l;
    }
}